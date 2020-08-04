package com.mod.user_service.service;

import com.mod.user_service.document.User;
import com.mod.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpResponse;

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

    public User post(User user, String jwt) {
        User found = userRepository.save(user);
        HttpHeaders headers = new HttpHeaders();
        jwt = "Bearer " + jwt;
        headers.add("Authorization", jwt);
        HttpEntity<String> entity = new HttpEntity<>("UserId", headers);
        ResponseEntity<String> result = restTemplate.exchange(
                "http://USER-COURSE-SERVICE/user-course/user/" + found.getUsername(),
                HttpMethod.POST,
                entity,
                String.class
        );
        return found;
    }

    public User put(User user) {
        User found = userRepository.findByUsername(user.getUsername()).orElse(null);
        if (userRepository.existsByUsername(user.getUsername()) && found != null) {
            found.setEmail(user.getEmail());
            found.setMobile(user.getMobile());
            found.setFullName(user.getFullName());
            found = userRepository.save(found);
        } else
            found = userRepository.save(user);

//        HttpHeaders headers = new HttpHeaders();
//        jwt = "Bearer " + jwt;
//        headers.add("Authorization", jwt);
//        HttpEntity<User> entity = new HttpEntity<>(found, headers);
//        ResponseEntity<String> result = restTemplate.exchange("http://USER-COURSE-SERVICE/user-course/user/", HttpMethod.PUT, entity, String.class);
        return found;
    }

}
