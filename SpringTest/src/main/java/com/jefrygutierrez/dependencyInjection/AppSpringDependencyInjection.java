package com.jefrygutierrez.dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppSpringDependencyInjection {

	public static void main(String[] args) {
		
		ApplicationContext appC= new ClassPathXmlApplicationContext("beans.xml");
		PersonalInformation pi=(PersonalInformation)appC.getBean("personal_information");
		pi.showInfo();
	}

}
