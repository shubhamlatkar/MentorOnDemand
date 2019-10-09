package com.project.Trainer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trainers {
	@Id
	private long id ;
	private String name;
	private String email;
	private String address;
	private String city;
	private String state;
	private String skills;
	private int fee;
	public Trainers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trainers(long id, String name, String email, String address, String city, String state, String skills,
			int fee) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.skills = skills;
		this.fee = fee;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "Trainers [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", skills=" + skills + ", fee=" + fee + "]";
	}
}
