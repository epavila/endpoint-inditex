package com.eavila.endpoint.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "endpoint Inditex",
                version = "1.0.0",
                description = "Method's Documentation api")
)
public class OpenApiConfig {
}
