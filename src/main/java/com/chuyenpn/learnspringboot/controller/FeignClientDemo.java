package com.chuyenpn.learnspringboot.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chuyenpn.learnspringboot.dto.Post;
import com.chuyenpn.learnspringboot.service.FeignClientService;

@RestController
public class FeignClientDemo {
	@Autowired
	private FeignClientService feignClient;
	
	@GetMapping("/feign-client/posts")
	public List<Post> getAllPost() {
		List<Post> posts = feignClient.getPosts();
		return posts;
	}
	
}
