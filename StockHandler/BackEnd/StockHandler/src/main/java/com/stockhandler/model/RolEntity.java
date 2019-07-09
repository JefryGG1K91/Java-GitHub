package com.stockhandler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rol")
public class RolEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "User Name cannot be null")
	@Column(name = "description")
	private String description;
	
	@Column(name = "rol_status")
	private boolean rol_status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isRol_status() {
		return rol_status;
	}

	public void setRol_status(boolean rol_status) {
		this.rol_status = rol_status;
	}
	
	
}
