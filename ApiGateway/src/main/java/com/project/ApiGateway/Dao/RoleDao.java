package com.project.ApiGateway.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ApiGateway.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

}
