package com.jefrygutierrez.dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppSpringDependencyInjection {

	public static void main(String[] args) {
		
		ApplicationContext appC= new AnnotationConfigApplicationContext(MyConfiguration.class);
		PersonalInformation pi=(PersonalInformation)appC.getBean("personal_bean");
		pi.showInfo();
	}

}
