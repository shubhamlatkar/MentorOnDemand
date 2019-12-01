package com.project.Training.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Training.model.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

}
