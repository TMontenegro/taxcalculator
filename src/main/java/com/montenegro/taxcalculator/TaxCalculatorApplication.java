package com.montenegro.taxcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TaxCalculatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaxCalculatorApplication.class, args);
	}
	
	@Configuration
	public class WebConfig implements WebMvcConfigurer {

		@Override 
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
			.allowedMethods("GET", "POST");
		}
	}
}
