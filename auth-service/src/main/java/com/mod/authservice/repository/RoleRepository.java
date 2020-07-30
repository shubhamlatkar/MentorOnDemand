package com.mod.authservice.repository;

import com.mod.authservice.document.auth.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    public Optional<Role> findByRole(String role);
}
