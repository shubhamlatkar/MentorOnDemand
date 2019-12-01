package com.project.Training.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Training.model.Training;

public interface TrainingDao extends JpaRepository<Training, Long>{

}
