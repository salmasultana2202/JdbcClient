package com.example.jdbcClientDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.SpringServletContainerInitializer;

@SpringBootApplication
public class JdbcClientDemoApplication extends SpringServletContainerInitializer {

	public static void main(String[] args) {
		SpringApplication.run(JdbcClientDemoApplication.class, args);
	}

}
