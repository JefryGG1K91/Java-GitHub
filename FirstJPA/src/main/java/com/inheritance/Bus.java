package com.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="bus")
@PrimaryKeyJoinColumn(referencedColumnName="id")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue(value="B")
public class Bus extends Vehicle{
	
	public Bus() {

	}
	
	
	public Bus(String name,int numberOfPassanger) {
		super(name);
		this.numberOfPassanger = numberOfPassanger;
	}

	private int numberOfPassanger;

	public int getNumberOfPassanger() {
		return numberOfPassanger;
	}

	public void setNumberOfPassanger(int numberOfPassanger) {
		this.numberOfPassanger = numberOfPassanger;
	}

}
