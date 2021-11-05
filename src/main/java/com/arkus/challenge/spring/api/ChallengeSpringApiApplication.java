package com.arkus.challenge.spring.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ChallengeSpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeSpringApiApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer(){
			public void addCorsMapping(CorsRegistry registry){
				registry.addMapping("/**").allowedOrigins("http://localhost:4200/").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

}
