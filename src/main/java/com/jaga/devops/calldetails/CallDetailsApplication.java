package com.jaga.devops.calldetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootApplication
public class CallDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallDetailsApplication.class, args);
	}
	
	@Bean
	public ObjectMapper mapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		return mapper;
	}
}
