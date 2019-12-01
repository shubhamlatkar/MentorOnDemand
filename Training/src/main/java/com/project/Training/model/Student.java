package com.project.Training.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private long id;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
	
}
