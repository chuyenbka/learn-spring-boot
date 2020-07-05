package com.chuyenpn.learnspringboot.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chuyenpn.learnspringboot.dto.Post;

@FeignClient(value = "jsonserver", url = "http://localhost:3000/")
public interface FeignClientService {

	@RequestMapping(method = RequestMethod.GET, value = "/posts")
	List<Post> getPosts();

	@RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
	Post getPostById(@PathVariable("postId") Long postId);
}
