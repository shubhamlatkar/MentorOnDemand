package com.mod.user_service.controller;

import com.mod.user_service.document.User;
import com.mod.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin("*")
@RestController
@RequestMapping("/user/")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> putUser(@PathVariable String name) {
        return ResponseEntity.ok().body(userRepository.findByName(name).orElse(null));
    }

    @PostMapping("/")
    public ResponseEntity<?> postUser(@RequestBody User user) {
        userRepository.save(user);
        ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:8083/user-course/user/", user, String.class);
//        Assert.(201, result.getStatusCodeValue());
        return ResponseEntity.ok().body(userRepository.findAll());
    }


}

