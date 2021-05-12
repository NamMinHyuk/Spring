package com.test01;

import java.util.Date;

public class BeanTest {

	public BeanTest() {
		System.out.println("BeanTest() 호출");
	}

	public BeanTest(Date date) {
		System.out.println("BeanTest(Date date) 호출 : " + date);
	}
	
	public void setMyClass(MyClass myClass) {
		System.out.println("setMyClass(Myclass myclass) 호출 : ");
		myClass.prn();
	}
	
	public void setDate(Date date) {
		System.out.println("setDate(Date date) 호출 : " + date);
	}
	
	public void setNumber(int num) {
		System.out.println("setNumber(int num) 호출 : " + num);
	}
	public void setArray(String[] arr) {
		System.out.println("setArray(String[] arr) 호출");
		for(String s : arr) {
			System.out.println(s);
		}
	}
}
