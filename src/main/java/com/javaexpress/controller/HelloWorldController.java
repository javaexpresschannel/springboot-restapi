package com.javaexpress.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping
	public String getHello() {
		return "Spring Boot application is running on Container";
	}
}
