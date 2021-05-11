package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		//bean으로 등록된 2명 출력
		Address hong = (Address)factory.getBean("hong");
		System.out.println(hong);
		
		Address lee = (Address)factory.getBean("lee");
		System.out.println(lee);
	}
}
