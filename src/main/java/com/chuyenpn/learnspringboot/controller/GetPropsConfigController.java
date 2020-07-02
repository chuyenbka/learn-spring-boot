package com.chuyenpn.learnspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuyenpn.learnspringboot.UserConfig;

@RestController
public class GetPropsConfigController {
	
	@Autowired
	UserConfig userConfig;
	
	@Value("${user-setting.maxLengthOfUsername}")
	String maxLengthOfUsername;

	@GetMapping("/get-config-1")
	public String getConfig1() {
		return String.format("max age = %s, min age = %s", userConfig.getMaxAge(), userConfig.getMinAge());
	}
	
	@GetMapping("/get-config-2")
	public String getConfig2() {
		return String.format("maxLengthOfUsername = %s chars", maxLengthOfUsername);
	}
}
