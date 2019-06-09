package com.jefrygutierrez;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppSpringTest {

	public AppSpringTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		ApplicationContext appC= new ClassPathXmlApplicationContext("beans.xml");
		
//		//scoope-singleton
//		Student stu1=(Student)appC.getBean("student_bean");
//		stu1.setStudentName("Peter parker");
//		System.out.println(stu1.getStudentName());
//		
		
		Student stu=(Student)appC.getBean("student_bean");
		System.out.println(stu.getStudentName());

		//este metodo solo sera ejecutado cuando el scoope del bean.xml sea de tipo 'singleton'
		((ConfigurableApplicationContext) appC).close();
	}

}
