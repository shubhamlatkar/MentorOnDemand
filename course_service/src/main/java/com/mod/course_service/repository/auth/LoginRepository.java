package com.mod.course_service.repository.auth;

import com.mod.course_service.document.auth.Login;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LoginRepository extends MongoRepository<Login, String> {
    public Boolean existsByUsername(String username);
    public Boolean existsByEmail(String email);
    public Optional<Login> findByUsername(String username);
    public Optional<Login> findByEmail(String email);

}
