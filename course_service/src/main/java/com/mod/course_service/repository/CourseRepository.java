package com.mod.course_service.repository;

import com.mod.course_service.document.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course,String> {
}
