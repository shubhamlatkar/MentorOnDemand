package com.project.User.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.User.model.Notifications;

public interface NotificationsDao extends JpaRepository<Notifications, Long> {
	public List<Notifications> findAllByStudentId(long studentId);
}
