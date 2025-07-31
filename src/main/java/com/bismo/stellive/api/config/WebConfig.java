package com.bismo.stellive.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해
                .allowedOrigins("http://localhost:3000", "http://localhost:3001") // 모든 origin 허용 (배포 시에는 제한하는 게 좋음)
                .allowedMethods("GET", "POST", "PUT", "DELETE","PATCH", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false) // true 시에는 allowedOrigins에 * 못 씀
                .maxAge(3600); // preflight 캐시 시간
    }
}