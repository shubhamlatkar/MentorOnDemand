package com.mod.user_service.service;

import com.mod.user_service.document.User;
import com.mod.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public User post(User user) {
        if (userRepository.existsByUsername(user.getUsername()))
            return user;
        return userRepository.save(user);
    }

    public User put(User user) {
        User found = userRepository.findByUsername(user.getUsername()).orElse(null);
        if (userRepository.existsByUsername(user.getUsername()) && found != null) {
            if (user.getFullName() != null) found.setFullName(user.getFullName());
            found = userRepository.save(found);
        } else
            found = userRepository.save(user);
        return found;
    }

    public User get(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public void delete(String username) {
        userRepository.findByUsername(username).ifPresent(userRepository::delete);
    }

}
