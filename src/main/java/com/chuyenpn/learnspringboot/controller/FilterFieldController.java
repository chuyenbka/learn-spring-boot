package com.chuyenpn.learnspringboot.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuyenpn.learnspringboot.filtering.DynamicFilterBean;
import com.chuyenpn.learnspringboot.filtering.FilterBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterFieldController {
	
	@GetMapping("/filter/demo1")
	public FilterBean demoFilter1() {
		return new FilterBean("field1", "field2", "field3");
	}
	
	@GetMapping("/filter/dynamic1")
	public MappingJacksonValue dynamicFilter1() {
		DynamicFilterBean bean = new DynamicFilterBean("field1", "field2", "field3");
		SimpleBeanPropertyFilter filterField = SimpleBeanPropertyFilter.filterOutAllExcept("field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("filterField", filterField);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bean);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
}
