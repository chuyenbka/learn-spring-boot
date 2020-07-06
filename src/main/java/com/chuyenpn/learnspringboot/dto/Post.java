package com.chuyenpn.learnspringboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
	private int id;
	@JsonProperty("title")
	private String titlePost;
	private String author;
	
	public Post() {
		
	}

	public Post(String titlePost, String author) {
		this.titlePost = titlePost;
		this.author = author;
	}
}
