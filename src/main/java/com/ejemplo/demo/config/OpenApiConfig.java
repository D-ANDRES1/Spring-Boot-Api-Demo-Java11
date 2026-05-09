package com.ejemplo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Mi API DEMO")
                        .version("1.0")
                        .description("API de ejemplo Spring Boot, aprendiendo")
                        .contact(new Contact()
                        .name("Andres")
                        .email("correo@test.com")));
    }

}
