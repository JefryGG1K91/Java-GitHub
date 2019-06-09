package com.jefrygutierrez.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;

public class PersonalInformation {

	public PersonalInformation() {}
	
	@Autowired
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
