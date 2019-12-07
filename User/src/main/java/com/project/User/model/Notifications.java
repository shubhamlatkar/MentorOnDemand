
package com.project.User.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Notifications {
	@Id
	private long id;
	private long studentId;
	private String msg;
	public Notifications() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notifications(long id, long studentId, String msg) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.msg = msg;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Notifications [id=" + id + ", studentId=" + studentId + ", msg=" + msg + "]";
	}
}
