package com.mod.user_service.repository;

import com.mod.user_service.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByUsername(String username);
    public Boolean existsByUsername(String username);
}
