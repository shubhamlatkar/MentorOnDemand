package com.project.Training.Dto;

public class EnrollForCourceDTO {
	private long studentId;
	private long courceId;
	@Override
	public String toString() {
		return "EnrollForCourceDTO [studentId=" + studentId + ", courceId=" + courceId + "]";
	}
	public EnrollForCourceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EnrollForCourceDTO(long studentId, long courceId) {
		super();
		this.studentId = studentId;
		this.courceId = courceId;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public long getCourceId() {
		return courceId;
	}
	public void setCourceId(long courceId) {
		this.courceId = courceId;
	}
}
