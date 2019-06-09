package com.relationship.manyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="professor")
public class Professor {


	@Id
	@Column(name="id_professor")
	@GeneratedValue
	private int id_professor;
	
	@Column(name="professor_name")
	private String name;
	
	@ManyToMany(mappedBy="professorList", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Project> projectList;

	public Professor() {
		
	}

	
	public Professor(String name) {
		super();
		this.name = name;
		this.projectList=new ArrayList<Project>();
	}

	public int getId() {
		return id_professor;
	}

	public String getName() {
		return name;
	}
	
	public void assingProjectToProfessor(Project project) {
		getProjectList().add(project);
	}


	private List<Project> getProjectList() {
		return projectList;
	}


	private void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
	
}
