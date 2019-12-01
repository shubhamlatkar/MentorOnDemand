package com.project.Training.model;

import java.util.Date;
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
	@OneToMany
	private List<TOC> toc;
	private Date startDate;
	private Date endDate;
	private float amount;
	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Training(long id, String name, boolean isCompleted, long mentorId, List<Student> students, List<TOC> toc,
			Date startDate, Date endDate, float amount) {
		super();
		this.id = id;
		this.name = name;
		this.isCompleted = isCompleted;
		this.mentorId = mentorId;
		this.students = students;
		this.toc = toc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
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
	public List<TOC> getToc() {
		return toc;
	}
	public void setToc(List<TOC> toc) {
		this.toc = toc;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Training [id=" + id + ", name=" + name + ", isCompleted=" + isCompleted + ", mentorId=" + mentorId
				+ ", students=" + students + ", toc=" + toc + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", amount=" + amount + "]";
	}
	
}
