package com.Nadir.cs393project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Cs393projectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cs393projectApplication.class, args);
	}

	@RequestMapping("/")
	public String sayHello() {
		StringBuffer sb=new StringBuffer();
		sb.append("Hello");
		return sb.toString();
	}

}
