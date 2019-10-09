package com.project.User.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class User {

	@Id
	private long id;
	@Email
	private String email;
	private String username;
	private int age;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(long id, @Email String email, String username, int age) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.age = age;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", age=" + age + "]";
	}
}
