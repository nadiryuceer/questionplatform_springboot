package com.Nadir.askdeveloper;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(version = "1.0",
		title = "Question Forum API",
		description = "All Administration Operations"))
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
