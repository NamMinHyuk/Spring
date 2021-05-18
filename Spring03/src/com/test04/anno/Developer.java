package com.test04.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class Developer {
	
	@Autowired
	@Qualifier("lee")
	private Emp emp;
	private String dept;
	
	public Developer() {
	}
	
	public Developer(Emp emp, String dept) {
		this.emp = emp;
		this.dept = dept;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return emp + " \t 개발 (" + dept + ")";
	}
	
}
