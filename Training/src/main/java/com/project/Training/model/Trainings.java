package com.project.Training.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trainings {
	@Id
	private long id;
	private float fee;
	private int courceCompleted;
	private int paymentCompleted;
	private long mentorId;
	private String name;
	
	public Trainings() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Trainings(long id, float fee, int courceCompleted, int paymentCompleted, long mentorId, String name) {
		super();
		this.id = id;
		this.fee = fee;
		this.courceCompleted = courceCompleted;
		this.paymentCompleted = paymentCompleted;
		this.mentorId = mentorId;
		this.name = name;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public int getCourceCompleted() {
		return courceCompleted;
	}
	public void setCourceCompleted(int courceCompleted) {
		this.courceCompleted = courceCompleted;
	}
	public int getPaymentCompleted() {
		return paymentCompleted;
	}
	public void setPaymentCompleted(int paymentCompleted) {
		this.paymentCompleted = paymentCompleted;
	}

	public long getMentorId() {
		return mentorId;
	}

	public void setMentorId(long mentorId) {
		this.mentorId = mentorId;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Trainings [id=" + id + ", fee=" + fee + ", courceCompleted=" + courceCompleted + ", paymentCompleted="
				+ paymentCompleted + ", mentorId=" + mentorId + ", name=" + name + "]";
	}
}
