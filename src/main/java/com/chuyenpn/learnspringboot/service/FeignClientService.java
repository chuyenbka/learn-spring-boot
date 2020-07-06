package com.chuyenpn.learnspringboot.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chuyenpn.learnspringboot.dto.Post;

@FeignClient(value = "jsonserver", url = "http://localhost:3000/")
public interface FeignClientService {

	@GetMapping("/posts")
	List<Post> getPosts();

	@GetMapping("/posts/{postId}")
	Post getPostById(@PathVariable("postId") Long postId);
}
