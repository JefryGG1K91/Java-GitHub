package xperiment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="department")
public class Deparment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="department_id")
	private Integer Id;
	
	@NotNull(message = "Name cannot be null")
	@Column(name="department_name")
	private String departmentName;
	
	@NotNull(message = "Department cannot be null")
	@Column(name="department_Location")
	private String departmentLocation;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
	
	@Override
	public String toString() {
		return this.departmentName;
	}
}
