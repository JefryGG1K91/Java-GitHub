package xperiment.model.employee;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import xperiment.model.department.Deparment;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer Id;
	
	@NotNull(message = "Name cannot be null")
	@Column(name="employee_name")
	private String name;
	
	@NotNull(message = "Last Name cannot be null")
	@Column(name="employee_last_name")
	private String lastname;
	
	@NotNull(message = "Birthday cannot be null")
	@Column(name="employee_birthday")
	private String birthDay;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "department_id")
	@NotNull(message="Department must be filled!")
	private Deparment department;
	
	
	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getBirthDay() {
		return birthDay;
	}


	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}


	public Deparment getDepartment() {
		return department;
	}


	public void setDepartment(Deparment department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return String.valueOf(Id)+";"+name+";"+lastname+";"+birthDay;
	}
	
}
