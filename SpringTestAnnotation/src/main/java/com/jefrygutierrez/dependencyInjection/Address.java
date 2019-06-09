package com.jefrygutierrez.dependencyInjection;

public class Address {

	private String Address;
	
	public Address() {
		Address="las palmas de herrera";
	}

	public Address(String address) {
		this.Address=address;
	}
	
	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

}
