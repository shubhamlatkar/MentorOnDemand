package com.project.Trainer.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Trainer.model.Trainer;

public interface TrainerDao extends JpaRepository<Trainer, Long> {
}
