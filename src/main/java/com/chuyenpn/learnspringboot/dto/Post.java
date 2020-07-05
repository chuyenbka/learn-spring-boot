package com.chuyenpn.learnspringboot.dto;

import lombok.Data;

@Data
public class Post {
	private int id;
	private String title;
	private String author;
	
	public Post() {
		
	}

	public Post(String titile, String author) {
		this.title = titile;
		this.author = author;
	}
}
