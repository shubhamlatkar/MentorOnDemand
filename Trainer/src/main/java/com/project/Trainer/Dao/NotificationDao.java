package com.project.Trainer.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Trainer.model.Notification;

public interface NotificationDao extends JpaRepository<Notification, Long>{

}
