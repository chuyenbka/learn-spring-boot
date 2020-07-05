package com.chuyenpn.learnspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuyenpn.learnspringboot.dto.LombokDemo;

@RestController
public class LombokDemoController {
	
	@GetMapping("/lombok/demo1")
	public LombokDemo demoLombok1() {
		LombokDemo lombok1 = new LombokDemo();
		lombok1.setBrandName("Hi");
		return lombok1;
	}
	
	@GetMapping("/lombok/demo2")
	public LombokDemo demoLombok2() {
		return new LombokDemo("Hello", 23);
	}
	
//	@GetMapping("/lombok/demo3")
//	public LombokDemo demoLombok3() {
//		return new LombokDemo("Hello");
//	}
}
