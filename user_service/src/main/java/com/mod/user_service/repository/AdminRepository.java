package com.mod.user_service.repository;

import com.mod.user_service.document.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AdminRepository extends MongoRepository<Admin, String> {
    public Optional<Admin> findByUsername(String username);

    public Boolean existsByUsername(String username);
}
