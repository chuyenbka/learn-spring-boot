package com.chuyenpn.learnspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chuyenpn.learnspringboot.dto.Post;
import com.chuyenpn.learnspringboot.service.FeignClientService;

import feign.FeignException;

@RestController
public class FeignClientDemo {
	@Autowired
	private FeignClientService feignClient;
	
	@GetMapping("/feign-client/posts")
	public List<Post> getAllPost() {
		try {
			return feignClient.getPosts();
		} catch(FeignException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	@GetMapping("/feign-client/posts/{id}")
	public Post getPostById(@PathVariable("id") Long id) {
		return feignClient.getPostById(id);
	}
	
}
