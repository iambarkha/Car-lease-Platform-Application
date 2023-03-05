package com.car.lease.inventoryservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Inventory API"))
public class AppConfig {
	 @Bean
	    public OpenAPI customizeOpenAPI() {
	        final String securitySchemeName = "bearerAuth";
	        return new OpenAPI()
	                .addSecurityItem(new SecurityRequirement()
	                        .addList(securitySchemeName))
	                .components(new Components()
	                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
	                                .name(securitySchemeName)
	                                .type(SecurityScheme.Type.HTTP)
	                                .scheme("bearer")
	                                .description(
	                                        "Provide the JWT token. JWT token can be obtained from the Login API.")
	                                .bearerFormat("JWT")));

	    }

}
