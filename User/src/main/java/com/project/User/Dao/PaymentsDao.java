package com.project.User.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.User.model.Payments;

public interface PaymentsDao extends JpaRepository<Payments, Long>{

}
