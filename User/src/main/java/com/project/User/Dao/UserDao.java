package com.project.User.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.User.model.User;

public interface UserDao extends JpaRepository<User, Long> {

}
