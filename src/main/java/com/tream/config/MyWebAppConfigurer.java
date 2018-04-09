package com.tream.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String path = "/**";
        registry.addMapping(path)
                .allowedMethods("GET", "POST", "OPTIONS", "DELETE", "PATCH")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .exposedHeaders("access-control-allow-headers",
                        "access-control-allow-methods",
                        "access-control-allow-origin",
                        "access-control-max-age",
                        "X-Frame-Options")
                .allowCredentials(false)
                .maxAge(3600);

        System.out.println("******跨域配置******");
        System.out.println(path);
    }



}