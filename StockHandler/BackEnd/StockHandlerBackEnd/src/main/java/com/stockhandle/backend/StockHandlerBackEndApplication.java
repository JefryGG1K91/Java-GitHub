package com.stockhandle.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan({"com.stockhandler.backend"})
@EnableJpaAuditing
public class StockHandlerBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockHandlerBackEndApplication.class, args);
	}

}
