package com.backend.todolist.auth.controller;

public class UserSignupResponse {
	
	private String username;
	private String token;
	private String email;
	
	protected UserSignupResponse() {
		
	}
	
	public UserSignupResponse(String username, String email,String token) {
		super();
		this.username = username;
		this.token = token;
		this.email=email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
