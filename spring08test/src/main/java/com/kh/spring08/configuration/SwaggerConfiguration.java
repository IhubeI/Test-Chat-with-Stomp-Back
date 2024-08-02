package com.kh.spring08.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

//    @Bean
//    public OpenAPI openAPI(@Value("${springdoc.open-api-version}") String openApiVersion) {
//        Info info = new Info().title("Demo Open API").version(openApiVersion);
//        info.description("Demo 오픈 API 입니다.");
////                .termsOfService("Team Dandi");
//
//        return new OpenAPI()
//                .components(new Components())
//                .info(info);
//    }

	@Bean
	public OpenAPI openAPI() {

		Info info = new Info().title("Demo 오픈 API").version("v0.0.1");
		info.description("Demo 오픈 API 입니다.");
		return new OpenAPI().info(info);
	}
}
