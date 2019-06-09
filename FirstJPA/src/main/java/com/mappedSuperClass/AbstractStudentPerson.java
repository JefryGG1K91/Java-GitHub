package com.mappedSuperClass;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractStudentPerson {

	public AbstractStudentPerson() {
		
	}
	
	protected String drivingLicence;
	
	public String getDrivingLicence() {
		return drivingLicence;
	}

	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}



}
