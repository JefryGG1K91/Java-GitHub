package com.relationship.manyToOne;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="university_table")
public class University {

	public University() {
		this.student= new ArrayList<StudentUniversity>();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="university_id")
	private int university_id;
	
	@Column(name="university_name")
	private String university_name;
	
	@OneToMany(mappedBy="university")
	private List<StudentUniversity> student;

	public University(String university_name) {
		super();
		this.university_name = university_name;
		this.student= new ArrayList<StudentUniversity>();
	}
	
	public void addStudent(StudentUniversity student) {
		this.student.add(student);
	}
	
	
}
