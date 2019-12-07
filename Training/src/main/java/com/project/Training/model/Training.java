package com.project.Training.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Training {
	@Id
	private long id;
	private String name;
	private boolean isCompleted;
	private long mentorId;
	@OneToMany
	private List<Student> students;
	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Training(long id, String name, boolean isCompleted, long mentorId, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.isCompleted = isCompleted;
		this.mentorId = mentorId;
		this.students = students;
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
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public long getMentorId() {
		return mentorId;
	}
	public void setMentorId(long mentorId) {
		this.mentorId = mentorId;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Training [id=" + id + ", name=" + name + ", isCompleted=" + isCompleted + ", mentorId=" + mentorId
				+ "]";
	}
		
}
