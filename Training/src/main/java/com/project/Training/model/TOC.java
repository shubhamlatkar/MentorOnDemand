package com.project.Training.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TOC {
	@Id
	private long id;
	private String name;
	public TOC() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TOC(long id, String name) {
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
		return "TOC [id=" + id + ", name=" + name + "]";
	}
}
