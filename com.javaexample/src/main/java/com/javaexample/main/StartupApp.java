package com.javaexample.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
//@EnableWebSecurity
@EnableJpaRepositories({"com.javaexample.model"})
@ComponentScan({"com.javaexample.model"})
@SpringBootApplication
public class StartupApp {

	public static void main(String[] args) {
	
		SpringApplication.run(StartupApp.class, args);

	}

}
