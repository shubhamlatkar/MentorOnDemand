package com.project.Training.model;

public class Skills {
	
	private long id;
	private String name;
	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Skills(long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "Skills [id=" + id + ", name=" + name + "]";
	}
}
