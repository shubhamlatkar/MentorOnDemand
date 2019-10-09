package com.project.User.Dto;

public class RequestDto {
	private long mentorId;
	private long userId;
	private long courceId;
	public RequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestDto(long mentorId, long userId, long courceId) {
		super();
		this.mentorId = mentorId;
		this.userId = userId;
		this.courceId = courceId;
	}
	public long getMentorId() {
		return mentorId;
	}
	public void setMentorId(long mentorId) {
		this.mentorId = mentorId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getCourceId() {
		return courceId;
	}
	public void setCourceId(long courceId) {
		this.courceId = courceId;
	}
	@Override
	public String toString() {
		return "RequestDto [mentorId=" + mentorId + ", userId=" + userId + ", courceId=" + courceId + "]";
	}
}
