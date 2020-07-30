package com.mod.user_service.repository.auth;

import com.mod.user_service.document.auth.Authorities;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthoritiesRepository extends MongoRepository<Authorities,String> {
    public Optional<Authorities> findByAuthority(String authority);
}
