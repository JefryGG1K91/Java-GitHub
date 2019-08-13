package com.stockhandle.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableJpaAuditing
@Configuration
//@EnableWebSecurity
public class StockHandlerBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockHandlerBackEndApplication.class, args);
	}
	

}
