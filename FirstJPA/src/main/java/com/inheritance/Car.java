package com.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="car")
@PrimaryKeyJoinColumn(referencedColumnName="id")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue(value="C")
public class Car extends Vehicle{

	public Car() {}
	
	public Car(String name,double speed) {
		super(name);
		this.speed=speed;
	}

	private double speed;

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	
	
}
