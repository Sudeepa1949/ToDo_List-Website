package com.backend.todolist.auth.controller;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class UserSignupRequest {
	@NotNull
	@NotEmpty(message="username is required")
    private String username;
    
    @NotEmpty(message = "Password is required")
    @Size(min=8, message = "Password length should be 8 characters or more")
    private String password;
    
    @NotEmpty(message = "User email is required")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;
	
    protected UserSignupRequest() {
    	
    }

	public UserSignupRequest(String username,String email, String password) {
		super();
		this.username = username;
		this.password = password;
		this.email=email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
    
}
