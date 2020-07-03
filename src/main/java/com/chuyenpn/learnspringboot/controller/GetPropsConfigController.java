package com.chuyenpn.learnspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuyenpn.learnspringboot.PaginationConfig;
import com.chuyenpn.learnspringboot.UserConfig;

@RestController
public class GetPropsConfigController {
	
	@Autowired
	UserConfig userConfig;
	
	@Autowired
	PaginationConfig paginationConfig;
	
	@Autowired
	Environment enviroment;
	
	@Value("${user-setting.maxLengthOfUsername}")
	String maxLengthOfUsername;

	@GetMapping("/get-config-1")
	public String getConfig1() {
		return String.format("max age = %s, min age = %s, itemsPerPage = %s",
				userConfig.getMaxAge(),
				userConfig.getMinAge(),
				paginationConfig.getItemsPerPage());
	}
	
	@GetMapping("/get-config-2")
	public String getConfig2() {
		return String.format("maxLengthOfUsername = %s chars", maxLengthOfUsername);
	}
	
	@GetMapping("/get-config-3")
	public String getConfig3() {
		return String.format("maxLengthOfUsername = %s chars", enviroment.getProperty("user-setting.minLengthOfUsername"));
	}
}
