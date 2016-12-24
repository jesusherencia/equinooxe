package com.equinooxe.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.TemplateException;

@Configuration
public class FreemakerConfiguration {
	 private final Logger log = LoggerFactory.getLogger(LoggingConfiguration.class);
	@Bean
	public freemarker.template.Configuration freemarkerConfiguration() throws IOException, TemplateException {
	    FreeMarkerConfigurationFactoryBean factoryBean = new FreeMarkerConfigurationFactoryBean();
	    factoryBean.setPreferFileSystemAccess(false);
	    factoryBean.setTemplateLoaderPath("classpath:/templates");
	    factoryBean.afterPropertiesSet();
	    return factoryBean.getObject();
	} 
	
	@Bean
	public InternalResourceViewResolver freeMarkerConfigurer() {
		 InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("templates");
	        viewResolver.setSuffix(".ftl");
	        log.info("\n================\n"+ "Configure Free Maker" +"\n===============\n");
	        return viewResolver;
	}

}
