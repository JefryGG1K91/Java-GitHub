package com.jefrygutierrez.dependencyInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@Configuration
public class MyConfiguration {

@Bean(name="personal_bean")
	public PersonalInformation getPersonalInformation() {
		return new PersonalInformation();
	}
@Bean(name="1")
	public Address getAddress() {
		return new Address("Santo Domingo");
	}
	
@Bean(name="2")
public Address getAddress2() {
	return new Address("Azua");
}
	
}
