package com.mod.course_service.repository.auth;

import com.mod.course_service.document.auth.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    public Optional<Role> findByRole(String role);
}
