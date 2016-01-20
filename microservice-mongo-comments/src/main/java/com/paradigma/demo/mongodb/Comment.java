package com.paradigma.demo.mongodb;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;


public class Comment {

	@Id
	private BigInteger id;
	


	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	private User user;
	
	private String text;



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
