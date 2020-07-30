package com.mod.authservice.repository;

import com.mod.authservice.document.auth.Authorities;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthoritiesRepository extends MongoRepository<Authorities,String> {
    public Optional<Authorities> findByAuthority(String authority);
}
