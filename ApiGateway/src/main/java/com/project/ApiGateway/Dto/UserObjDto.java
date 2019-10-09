package com.project.ApiGateway.Dto;

public class UserObjDto {
	private long id;
	private String username;
	private String role;
	public UserObjDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserObjDto(long id, String username, String role) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserObjDto [id=" + id + ", username=" + username + ", role=" + role + "]";
	}
	
}
