package com.relationship;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class Location {

	public Location() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="zip_code")
	private int zipCode;
	@Column(name="address_name")
	private String addressName;
	
	@OneToOne
	@JoinColumn(name="employeeId")
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Location(int zipCode, String addressName) {
		super();
		this.zipCode = zipCode;
		this.addressName = addressName;
	}
	
	
	
}
