package com.equinooxe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.equinooxe.domain.listeners.AfterSaveUser;

/**
 * Configure,Gather and load All Equinooxe Aspects related to Notifications
 * All Eq Aspect should be declared in this class to be loaded and visible to Spring
 * @author mboullouz
 *
 */
@Configuration
@EnableAspectJAutoProxy
public class EqNotificationAspectConfiguration {

    @Bean
    public AfterSaveUser NotifAspectAspect() {
        return new AfterSaveUser(); 
    }
}
