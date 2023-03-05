package com.car.lease.brokerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Customer API"))
@SecurityScheme(name = "bearerAuth", scheme = "bearer", bearerFormat ="JWT", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class BrokerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrokerServiceApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
