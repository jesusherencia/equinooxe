package com.equinooxe.config;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.equinooxe.domain.util.J8PebbleExtension;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.Loader;
import com.mitchellbosecke.pebble.loader.ServletLoader;
import com.mitchellbosecke.pebble.spring4.PebbleViewResolver;
import com.mitchellbosecke.pebble.spring4.extension.SpringExtension; 


@Configuration
@ComponentScan(basePackages = { "com.equinooxe"})
@EnableWebMvc
public class PebbleTemplateConfiguration  extends WebMvcConfigurerAdapter {
@Autowired
    private ServletContext servletContext;
	
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
	}

    @Bean
    public Loader templateLoader(){
        return new ServletLoader(servletContext);
    }

    @Bean
    public SpringExtension springExtension() {
        return new SpringExtension();
    }

    @Bean 
    public PebbleEngine pebbleEngine() {
         return new PebbleEngine.Builder().strictVariables(true)
                .loader(this.templateLoader())
                .extension(
                		springExtension(), 
                		new J8PebbleExtension())
                .build();
    }  

    @Bean
    public ViewResolver viewResolver() {
        PebbleViewResolver viewResolver = new PebbleViewResolver();
        viewResolver.setPrefix("/WEB-INF/templates/");
        viewResolver.setSuffix(".html.twig");
        viewResolver.setPebbleEngine(pebbleEngine());
        return viewResolver;
    }
    
}