package com.vinay.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
public class AppConfig {
	
	
	@Bean
	public SecurityFilterChain securityConfigrationChain(HttpSecurity http) throws Exception {
		
		http
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST, "/api/clients/").permitAll()
		.requestMatchers( "/v3/api-docs").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.addFilterAfter(new JwtGenraterTokanFilter(), BasicAuthenticationFilter.class)
		.addFilterBefore(new JwtTokanValideterFilter(), BasicAuthenticationFilter.class)
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
