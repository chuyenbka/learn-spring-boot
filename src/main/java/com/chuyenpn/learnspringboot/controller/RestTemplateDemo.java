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

@RestController
public class RestTemplateDemo {
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/rest-client/posts")
	public List<Post> getAllPost() {
		String url = "http://localhost:3000/posts";
		ResponseEntity<List> responeEntity = restTemplate.getForEntity(url, List.class);
		return responeEntity.getBody();
	}
	
	@GetMapping("/rest-client/posts/{id}")
	public Post getPost(@PathVariable("id") String id) {
		String url = "http://localhost:3000/posts/" + id;
		return restTemplate.getForObject(url, Post.class);
	}
	
	@PostMapping("/rest-client/posts")
	public Post doPost(@RequestBody Post post) {
		String url = "http://localhost:3000/posts";
		RequestEntity<Post> requestEntity;
		try {
			requestEntity = new RequestEntity<>(
					post,
					HttpMethod.POST,
					new URI(url));
			ResponseEntity<Post> exchange = restTemplate.exchange(requestEntity, Post.class);
			return exchange.getBody();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
