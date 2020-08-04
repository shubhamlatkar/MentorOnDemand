package com.mod.course_service.repository;

import com.mod.course_service.document.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends MongoRepository<Course,String> {
    public Optional<Course> findByTitle(String title);
    public Boolean existsByTitle(String title);
    public Optional<List<Course>> findAllByTitleContains(String keyword);

}
