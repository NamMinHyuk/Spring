package com.hello.mvc.model;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {

	public String getHello() {
		// TODO : 06. dao에서 return
		return "Spring";
	}
}
