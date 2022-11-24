package com.backend.todolist.auth.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="UserDetails")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    
    @NotEmpty(message = "Username is required")
    @Column(unique = true)
    
   
    private String username;
    
    
    @NotEmpty(message = "Password is required")
    private String password;
    
    private String role;
    
    @Column(unique = true)
	private String email;

    protected User() {
		
	}

    public User(String username, String password,String email) {
		super();
		this.username = username;
		this.password = password;
		this.role = "User";
		this.email=email;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<String> getRoleAsList() {
        return Arrays.asList(this.role);
    }

    public String getRole() {
		return role;
	}

	public void setRoles(String role) {
        this.role = role;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}