package com.mod.user_course.repository;

import com.mod.user_course.document.UserCourse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserCourseRepository extends MongoRepository<UserCourse, String> {
    public Optional<UserCourse> findByName(String name);

    @Query("{'courses.title': {$eq: ?0}}")
    public Optional<List<UserCourse>> findByCourseTitle(String courseTitle);
}
