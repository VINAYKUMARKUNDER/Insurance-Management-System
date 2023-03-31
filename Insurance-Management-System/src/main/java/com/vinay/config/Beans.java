package com.vinay.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class Beans {
	
	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

}
