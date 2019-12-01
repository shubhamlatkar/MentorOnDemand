package com.project.Training.Dto;

import java.util.List;

import com.project.Training.model.Skills;


public class TrainingDto {
	private long id;
	private String name;
	private long mentorId;
	private String mentorName;
	private boolean isCompleted;
	private List<Skills> skills;
	public TrainingDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrainingDto(long id, String name, long mentorId, String mentorName, boolean isCompleted,
			List<Skills> skills) {
		super();
		this.id = id;
		this.name = name;
		this.mentorId = mentorId;
		this.mentorName = mentorName;
		this.isCompleted = isCompleted;
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
	public long getMentorId() {
		return mentorId;
	}
	public void setMentorId(long mentorId) {
		this.mentorId = mentorId;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public List<Skills> getSkills() {
		return skills;
	}
	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}
	@Override
	public String toString() {
		return "TrainingDto [id=" + id + ", name=" + name + ", mentorId=" + mentorId + ", mentorName=" + mentorName
				+ ", isCompleted=" + isCompleted + "]";
	}
	
}
