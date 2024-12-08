package com.goevents.w2051767_goevents.backend.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigCORS implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registryForCORS){
        registryForCORS.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}
