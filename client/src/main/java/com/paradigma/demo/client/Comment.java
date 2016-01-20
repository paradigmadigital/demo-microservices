package com.paradigma.demo.client;

import java.math.BigInteger;


public class Comment {

	
	private BigInteger id;
	
	private User user;
	
	private String text;

	

	public Comment() {
		super();

	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}




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
