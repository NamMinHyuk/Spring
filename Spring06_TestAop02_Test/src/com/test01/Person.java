package com.test01;

import org.springframework.stereotype.Component;

public class Person implements Human {

	String name;
	String job;
	
	
	public Person() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String sayName(String name) {
		System.out.println("나의 이름은 " + name + "입니다.");
		return String.format("나의 이름은 %s 입니다.", name);
	}

	@Override
	public String sayJob(String job) {
		System.out.println("나의 직업은 " + job + "입니다.");
		return String.format("나의 직업은 %s 입니다.", job);
	}

}
