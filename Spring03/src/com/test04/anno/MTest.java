package com.test04.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/anno/applicationContext.xml");
		
		Developer lee = (Developer) factory.getBean("developer");
		Engineer hong = factory.getBean("engineer", Engineer.class);
		
		System.out.println(lee);
		System.out.println(hong);
		
	}
}
