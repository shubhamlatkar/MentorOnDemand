package com.project.User.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payments {
	@Id
	private long id;
	private int total;
	private int completed;
	private int remaning;
	private String cource;
	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payments(long id, int total, int completed, int remaning, String cource) {
		super();
		this.id = id;
		this.total = total;
		this.completed = completed;
		this.remaning = remaning;
		this.cource = cource;
	}
	@Override
	public String toString() {
		return "Payments [id=" + id + ", total=" + total + ", completed=" + completed + ", remaning=" + remaning
				+ ", cource=" + cource + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	public int getRemaning() {
		return remaning;
	}
	public void setRemaning(int remaning) {
		this.remaning = remaning;
	}
	public String getCource() {
		return cource;
	}
	public void setCource(String cource) {
		this.cource = cource;
	}
}
