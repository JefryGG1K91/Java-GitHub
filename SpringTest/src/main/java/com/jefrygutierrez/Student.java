package com.jefrygutierrez;

public class Student {

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public void sayHello() {
		System.out.println("Hello , My name is jefry");
	}
	
	public void initStudent() {
		System.out.println("Init student method called.....");
	}
	
	private String studentName;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	//este metodo solo sera ejecutado cuando el scoope del bean.xml sea de tipo 'singleton'
	public void destroyStudent() {
		System.out.println("Destroy student method called.....");
	}
}
