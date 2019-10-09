package com.project.User.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long id;
	@JsonProperty
	private boolean accepted;
	private boolean isRead;
	private String msg;
	private long byUserId;
	private long courceId;
	private long forTrainerId;
			
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getByUserId() {
		return byUserId;
	}

	public void setByUserId(long byUserId) {
		this.byUserId = byUserId;
	}

	public long getCourceId() {
		return courceId;
	}

	public void setCourceId(long courceId) {
		this.courceId = courceId;
	}

	public long getForTrainerId() {
		return forTrainerId;
	}

	public void setForTrainerId(long forTrainerId) {
		this.forTrainerId = forTrainerId;
	}

	public Notification(long id, boolean accepted, boolean isRead, String msg, long byUserId, long courceId,
			long forTrainerId) {
		super();
		this.id = id;
		this.accepted = accepted;
		this.isRead = isRead;
		this.msg = msg;
		this.byUserId = byUserId;
		this.courceId = courceId;
		this.forTrainerId = forTrainerId;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", accepted=" + accepted + ", isRead=" + isRead + ", msg=" + msg
				+ ", byUserId=" + byUserId + ", courceId=" + courceId + ", forTrainerId=" + forTrainerId + "]";
	}	
	
}
