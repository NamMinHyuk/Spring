package com.test06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	@Before("execution(public * *(..))")
	public void before() {
		System.out.println("출석카드를 찍는다.");
	}
	
	@After("execution(public * *(..))")
	public void after() {
		System.out.println("집에 간다.");
	}
	
	public void myClass() {
		// 사용 안해도 됨!
	}
}
