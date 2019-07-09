package com.stockhandle.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="rol")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"createAt","updateAt"}, allowGetters = true)
public class Rol implements Serializable{
	
	private static final long serialVersionUID = 1221065940432421435L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Description cannot be null")
	@Column(name="description")
	private String description;
	
	@Column(name="rol_status")
	private boolean rolStatus;

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

	public boolean isRolStatus() {
		return rolStatus;
	}

	public void setRolStatus(boolean rolStatus) {
		this.rolStatus = rolStatus;
	}
	
	
	
	
}
