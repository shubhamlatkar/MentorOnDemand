package com.project.Training.Dto;

import java.util.Date;
import java.util.List;

public class AllTrainingDTO {
	private long id;
	private int completed;
	private int amount;
	private String name;
	private List<String> toc;
	private Date startDate;
	private Date endDate;
	
	@Override
	public String toString() {
		return "AllTrainingDTO [id=" + id + ", completed=" + completed + ", amount=" + amount + ", name=" + name
				+ ", toc=" + toc + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	public AllTrainingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AllTrainingDTO(long id, int completed, int amount, String name, List<String> toc, Date startDate,
			Date endDate) {
		super();
		this.id = id;
		this.completed = completed;
		this.amount = amount;
		this.name = name;
		this.toc = toc;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getToc() {
		return toc;
	}
	public void setToc(List<String> toc) {
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
}
