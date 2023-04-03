package com.vinay.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class AppConfig {
	
	@Bean
	public SecurityFilterChain securityConfigrationChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST, "/api/clients/").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.csrf().disable()
		.formLogin()
		.and()
		.httpBasic();
		
		return http.build();
		
	}
	
	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
 

}
