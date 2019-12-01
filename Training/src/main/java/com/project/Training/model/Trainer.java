package com.project.Training.model;

import java.util.List;

import javax.validation.constraints.Email;


public class Trainer {
	
	private long id;
	private String name;
	
	private String email;
	
	private List<Skills> skills;
	
	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trainer(long id, String name, @Email String email, List<Skills> skills) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.skills = skills;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Skills> getSkills() {
		return skills;
	}
	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}
	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", email=" + email + ", skills=" + skills + "]";
	}
}
