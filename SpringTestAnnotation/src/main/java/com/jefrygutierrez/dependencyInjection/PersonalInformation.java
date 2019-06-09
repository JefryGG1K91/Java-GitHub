package com.jefrygutierrez.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PersonalInformation {

	public PersonalInformation() {}
	
	@Autowired
	@Qualifier(value="1")
	private  Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public PersonalInformation(Address addressIncome) {
		
		this.address=addressIncome;
	}
	
	public void showInfo() {
		System.out.println("This is the information: "+address.getAddress());
	}
	
}
