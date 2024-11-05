package com.example.odrowonsz.configs;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    //public final String JWT_AUTH = "JWT_AUTH";

    @Bean
    public OpenAPI configureOpenAPI() {
        return new OpenAPI();
    }



}
