package com.project.User.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.User.model.Notification;

public interface NotificationDao extends JpaRepository<Notification, Long>{
	public Notification findByForTrainerId(long forTrainerId);
}
