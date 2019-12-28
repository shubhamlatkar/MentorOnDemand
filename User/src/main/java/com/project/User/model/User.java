package com.project.User.model;

import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.validation.constraints.Email;

// @Entity
// public class User {

// 	@Id
// 	private long id;
// 	@Email
// 	private String email;
// 	private String name;
// 	private String address;
// 	private String city;
// 	private String state;
// 	private String skill;
// 	private int fee;
// 	public User() {
// 		super();
// 		// TODO Auto-generated constructor stub
// 	}
// 	public User(long id, @Email String email, String name, String address, String city, String state, String skill,
// 			int fee) {
// 		super();
// 		this.id = id;
// 		this.email = email;
// 		this.name = name;
// 		this.address = address;
// 		this.city = city;
// 		this.state = state;
// 		this.skill = skill;
// 		this.fee = fee;
// 	}
// 	public long getId() {
// 		return id;
// 	}
// 	public void setId(long id) {
// 		this.id = id;
// 	}
// 	public String getEmail() {
// 		return email;
// 	}
// 	public void setEmail(String email) {
// 		this.email = email;
// 	}
// 	public String getName() {
// 		return name;
// 	}
// 	public void setName(String name) {
// 		this.name = name;
// 	}
// 	public String getAddress() {
// 		return address;
// 	}
// 	public void setAddress(String address) {
// 		this.address = address;
// 	}
// 	public String getCity() {
// 		return city;
// 	}
// 	public void setCity(String city) {
// 		this.city = city;
// 	}
// 	public String getState() {
// 		return state;
// 	}
// 	public void setState(String state) {
// 		this.state = state;
// 	}
// 	public String getSkill() {
// 		return skill;
// 	}
// 	public void setSkill(String skill) {
// 		this.skill = skill;
// 	}
// 	public int getFee() {
// 		return fee;
// 	}
// 	public void setFee(int fee) {
// 		this.fee = fee;
// 	}
// 	@Override
// 	public String toString() {
// 		return "User [id=" + id + ", email=" + email + ", name=" + name + ", address=" + address + ", city=" + city
// 				+ ", state=" + state + ", skill=" + skill + ", fee=" + fee + "]";
// 	}
// }


@Entity
public class User {

	@Id
	long userId;
	String name;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + "]";
	}

}