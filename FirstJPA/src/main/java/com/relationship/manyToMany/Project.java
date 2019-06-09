package com.relationship.manyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {

	@Id
	@Column(name="id_project")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_project;
	
	@Column(name="project_name")
	private String projectName;
	
	@ManyToMany
	@JoinTable(name="professor_projects", 
	joinColumns=@JoinColumn(name="id_project"), 
	inverseJoinColumns=@JoinColumn(name="id_professor"))
	private List<Professor> professorList;
	
	public Project() {
		
	}

	public Project(String projectName) {
		super();
		this.projectName = projectName;
		this.professorList= new ArrayList<Professor>();
	}
	public int getId() {
		return id_project;
	}
	public void setId(int id) {
		this.id_project = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<Professor> getProfessorList() {
		return professorList;
	}
	public void setProfessorList(List<Professor> professorList) {
		this.professorList = professorList;
	}
	
	public void assingProfessorToProject(Professor professor) {
		professorList.add(professor);
	}
	
}
