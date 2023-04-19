package com.inditex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class ProductosInditexApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductosInditexApplication.class, args);
	}
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Productos Inditex")
						.version("0.1")
						.description("Aplicación para la consulta de precios finales")
						.termsOfService("https://www.inditex.com")
						.license(new License().name("Licencia Inditex").url("https://www.inditex.com")));
				
	}

}
