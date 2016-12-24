package com.equinooxe.config;

import org.apache.commons.lang3.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.thymeleaf.cache.StandardCacheManager;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration 
public class ThymeleafConfiguration {

    @SuppressWarnings("unused")
    private final Logger log = LoggerFactory.getLogger(ThymeleafConfiguration.class);
    private SpringTemplateEngine templateEngine;
    
    @Bean
    @Description("Thymeleaf template resolver serving HTML 5 emails")
    public ClassLoaderTemplateResolver emailTemplateResolver() {
        ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
        emailTemplateResolver.setPrefix("mails/");
        emailTemplateResolver.setSuffix(".html");
        emailTemplateResolver.setTemplateMode("LEGACYHTML5");
        emailTemplateResolver.setCharacterEncoding(CharEncoding.UTF_8);
        emailTemplateResolver.setOrder(1);
        log.info("\n=============== Email TemplateResolver legacy and staff");
        return emailTemplateResolver;
    }
    
    @Autowired
    private Environment env;

    @Bean
    public TemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("LEGACYHTML5");
        resolver.setCharacterEncoding(CharEncoding.UTF_8);
        if (env.acceptsProfiles(Constants.SPRING_PROFILE_DEVELOPMENT)) {
            resolver.setCacheable(false); // default is true (for prod)
        } else {
            log.info("\n===============Cache des templates Thymeleaf activé");
        }
        log.info("\n=============== templateResolver");
        return resolver;
    }
    
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
//        engine.addDialect(new ConditionalCommentsDialect());
        engine.addDialect(new LayoutDialect());
        if (env.acceptsProfiles(Constants.SPRING_PROFILE_PRODUCTION)) {
            log.info("Cache manager activé");
            engine.setCacheManager(thymeleafCacheManager());
        }
        return engine;
    }
 
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding(CharEncoding.UTF_8);
        log.info("\n=============== thymeleafViewResolver");
        return resolver;
    }

    @Bean
    public StandardCacheManager thymeleafCacheManager() {
        StandardCacheManager cacheManager = new StandardCacheManager();
        cacheManager.setTemplateCacheMaxSize(500);
        cacheManager.setFragmentCacheMaxSize(1000);
        log.info("\n=============== thymeleafCacheManager");
        return cacheManager;
    }
    
   
}
