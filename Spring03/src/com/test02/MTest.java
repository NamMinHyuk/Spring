package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Emp hong = (Emp) factory.getBean("hong");
		Emp lee = (Emp) factory.getBean("lee");
		
		System.out.println(hong);
		System.out.println(lee);
		
	}
}
