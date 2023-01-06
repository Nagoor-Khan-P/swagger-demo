package com.fullstack.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiig {
	
	@Bean
	public Docket SwaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/coursesapi/**"))
				.apis(RequestHandlerSelectors.basePackage("com.fullstack"))
				.build()
				.apiInfo(ApiInfoDetails());
	}

	private ApiInfo ApiInfoDetails() {
		// TODO Auto-generated method stub
		return new ApiInfo("Courses API Information", 
				"Information about the Every Course",
				"1.0", 
				"Free of Cost", 
				new Contact("Nagoor Khan Patan", "https://MyProfile.com", "official.nagoork74@gmail.com"), 
				"Free trail for one month", 
				"https://MyProfile.com",
				Collections.emptyList());
	}
}
