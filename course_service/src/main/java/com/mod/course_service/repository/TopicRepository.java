package com.mod.course_service.repository;

import com.mod.course_service.document.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TopicRepository extends MongoRepository<Topic, String> {
    public Optional<Topic> findByName(String name);
}
