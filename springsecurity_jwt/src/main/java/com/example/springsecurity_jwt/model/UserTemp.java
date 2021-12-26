package com.example.springsecurity_jwt.model;

public class UserTemp {
	
    private Long id;
    private String username;
    private String password;
    private Long userId;
	private String[] permissions;
    
	public UserTemp(Long id, String username, String password, Long userId, String[] permissions) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userId = userId;
		this.permissions = permissions;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

    public String[] getPermissions() {
		return permissions;
	}

	public void setPermissions(String[] permissions) {
		this.permissions = permissions;
	}



}
