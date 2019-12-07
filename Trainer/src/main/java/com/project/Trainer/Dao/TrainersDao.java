package com.project.Trainer.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Trainer.model.Trainers;

public interface TrainersDao extends JpaRepository<Trainers, Long> {

}
