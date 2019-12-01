package com.project.ApiGateway.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ApiGateway.model.User;

public interface UserDao extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
