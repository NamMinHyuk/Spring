package com.test01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.context.ApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		MyNickNamePrn myNick = factory.getBean("myNickNamePrn",MyNickNamePrn.class);
				System.out.println(myNick);
	}
}
