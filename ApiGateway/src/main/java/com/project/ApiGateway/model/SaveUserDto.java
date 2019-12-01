package com.project.ApiGateway.model;

public class SaveUserDto {
	private long id;
	private String username;
	private String password;
	private long roleId;
	
	public SaveUserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaveUserDto(long id, String username, String password, long roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "SaveUserDto [id=" + id + ", username=" + username + ", password=" + password + ", roleId=" + roleId
				+ "]";
	}
	
}
