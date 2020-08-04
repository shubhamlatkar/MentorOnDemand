package com.mod.user_service.repository;

import com.mod.user_service.document.Trainer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TrainerRepository extends MongoRepository<Trainer, String> {

    public Boolean existsByUsername(String username);
    public Optional<Trainer> findByUsername(String username);
}
