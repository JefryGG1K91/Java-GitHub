package com.stockhandler.startapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories({"com.stockhandler"})
//@ComponentScan({"com.stockhandler"})
//@EntityScan({"com.stockhandler"})
public class StockHandlerApplication {
	public static void main(String[] args) {
		SpringApplication.run(StockHandlerApplication.class, args);
	}

}
