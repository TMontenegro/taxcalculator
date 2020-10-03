package com.montenegro.taxcalculator.swagger;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@PropertySource("classpath:application.properties")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build().apiInfo( new ApiInfo(
        	      "Tax Calculator", 
        	      "Demo project for Liferay Interview", 
        	      null, 
        	      null, 
        	      new Contact("Tales Montenegro", "https://github.com/TMontenegro", "contatotalesmontenegro@gmail.com"), 
        	      null, null, Collections.emptyList()));                                           
    }

}


