package com.javawebtutor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="person")
@NamedQueries({
@NamedQuery(name="person.getAll", query="SELECT p From Person p"),
@NamedQuery(name="person.getById", query="SELECT p From Person p WHERE p.id= :id"),
})
public class Person {

	public Person() {
		
	}
	
	public String toString() {
		
		return id+" "+name+" "+email;
	}
	
	public Person(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	

}
