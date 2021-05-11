package com.test02;

public class MTest {

	public static void main(String[] args) {
		// interface가 중간에 있어서 결합도가 낮아졌다.
		MessageBean bean = new MessageBeanEn();
		bean.sayHello("Spring");
		
		bean = new MessageBeanKo();
		bean.sayHello("스프링");
	}

}
