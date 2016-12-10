package com.equinooxe.config;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlet.InstrumentedFilter;
import com.codahale.metrics.servlets.MetricsServlet;
import com.equinooxe.web.filter.CachingHttpHeadersFilter;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.embedded.*;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;

import java.io.File;
import java.nio.file.Paths;
import java.util.*;
import javax.inject.Inject;
import javax.servlet.*;

/**
 * Configuration of web application with Servlet 3.0 APIs.
 */
@Configuration
public class WebConfigurer implements ServletContextInitializer, EmbeddedServletContainerCustomizer {

	private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

	@Inject
	private Environment env;

	@Inject
	private JHipsterProperties jHipsterProperties;

	@Autowired(required = false)
	private MetricRegistry metricRegistry;

	@Autowired
	private SpringTemplateEngine templateEngine;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		if (env.getActiveProfiles().length != 0) {
			log.info("Web application configuration, using profiles: {}", Arrays.toString(env.getActiveProfiles()));
		}
		EnumSet<DispatcherType> disps = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD,
				DispatcherType.ASYNC);
		initMetrics(servletContext, disps);
		if (env.acceptsProfiles(Constants.SPRING_PROFILE_PRODUCTION)) {
			initCachingHttpHeadersFilter(servletContext, disps);
		}

		boolean found = false;
		IDialect dial = null;
		for (IDialect t : templateEngine.getDialects()) {
			if (t instanceof LayoutDialect) {
				found = true;
				dial = t;
			}
		}
		if (!found) {
			log.info("\n========= Thymleaf dialect add conf (*__*) ===============\n");
			templateEngine.addDialect(new LayoutDialect());
		} else {
			if (dial != null) {
				log.info("\n========= Dialect found :)" + dial.getPrefix() + " ===============\n");

			}
		}

		log.info("Web application fully configured");
	}

	/**
	 * Customize the Servlet engine: Mime types, the document root, the cache.
	 * 
	 * @param container
	 */
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
		// IE issue, see https://github.com/jhipster/generator-jhipster/pull/711
		mappings.add("html", "text/html;charset=utf-8");
		// CloudFoundry issue, see
		// https://github.com/cloudfoundry/gorouter/issues/64
		mappings.add("json", "text/html;charset=utf-8");
		container.setMimeMappings(mappings);
		// When running in an IDE or with ./mvnw spring-boot:run, set location
		// of the static web assets.
		setLocationForStaticAssets(container);
	}

	private void setLocationForStaticAssets(ConfigurableEmbeddedServletContainer container) {
		File root;
		String prefixPath = resolvePathPrefix();
		if (env.acceptsProfiles(Constants.SPRING_PROFILE_PRODUCTION)) {
			root = new File(prefixPath + "target/www/");
		} else {
			root = new File(prefixPath + "src/main/webapp/");
		}
		if (root.exists() && root.isDirectory()) {
			container.setDocumentRoot(root);
		}
	}

	/**
	 * Resolve path prefix to static resources.
	 */
	private String resolvePathPrefix() {
		String fullExecutablePath = this.getClass().getResource("").getPath();
		String rootPath = Paths.get(".").toUri().normalize().getPath();
		String extractedPath = fullExecutablePath.replace(rootPath, "");
		int extractionEndIndex = extractedPath.indexOf("target/");
		if (extractionEndIndex <= 0) {
			return "";
		}
		return extractedPath.substring(0, extractionEndIndex);
	}

	/**
	 * Initializes the caching HTTP Headers Filter.
	 */
	private void initCachingHttpHeadersFilter(ServletContext servletContext, EnumSet<DispatcherType> disps) {
		log.debug("Registering Caching HTTP Headers Filter");
		FilterRegistration.Dynamic cachingHttpHeadersFilter = servletContext.addFilter("cachingHttpHeadersFilter",
				new CachingHttpHeadersFilter(jHipsterProperties));

		cachingHttpHeadersFilter.addMappingForUrlPatterns(disps, true, "/content/*");
		cachingHttpHeadersFilter.addMappingForUrlPatterns(disps, true, "/app/*");
		cachingHttpHeadersFilter.setAsyncSupported(true);
	}

	/**
	 * Initializes Metrics.
	 */
	private void initMetrics(ServletContext servletContext, EnumSet<DispatcherType> disps) {
		log.debug("Initializing Metrics registries");
		servletContext.setAttribute(InstrumentedFilter.REGISTRY_ATTRIBUTE, metricRegistry);
		servletContext.setAttribute(MetricsServlet.METRICS_REGISTRY, metricRegistry);

		log.debug("Registering Metrics Filter");
		FilterRegistration.Dynamic metricsFilter = servletContext.addFilter("webappMetricsFilter",
				new InstrumentedFilter());

		metricsFilter.addMappingForUrlPatterns(disps, true, "/*");
		metricsFilter.setAsyncSupported(true);

		log.debug("Registering Metrics Servlet");
		ServletRegistration.Dynamic metricsAdminServlet = servletContext.addServlet("metricsServlet",
				new MetricsServlet());

		metricsAdminServlet.addMapping("/management/jhipster/metrics/*");
		metricsAdminServlet.setAsyncSupported(true);
		metricsAdminServlet.setLoadOnStartup(2);
	}

	@Bean
	@ConditionalOnProperty(name = "jhipster.cors.allowed-origins")
	public CorsFilter corsFilter() {
		log.debug("Registering CORS filter");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = jHipsterProperties.getCors();
		source.registerCorsConfiguration("/api/**", config);
		source.registerCorsConfiguration("/v2/api-docs", config);
		source.registerCorsConfiguration("/oauth/**", config);
		return new CorsFilter(source);
	}
}