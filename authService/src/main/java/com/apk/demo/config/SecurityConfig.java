package com.apk.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig 
{
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{	//authorize the request based on the end point(url)
		http
		.csrf(csrf -> csrf.disable()) //disable for simplicity
		.authorizeHttpRequests(auth -> auth
				.requestMatchers(		//for end-point
						"/api/auth/**"
						).permitAll()
				.requestMatchers(		//for swagger-ui
						"/swagger-ui",
						"/swagger-ui/index.html",
						"/swagger-ui/**",
						"/v3/api-docs/**",
						"/v3/api-docs"
						).permitAll()
				);
		return http.build();
		
	}
}
