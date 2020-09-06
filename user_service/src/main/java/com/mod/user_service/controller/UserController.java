package com.mod.user_service.controller;

import com.mod.user_service.document.payload.request.UserDto;
import com.mod.user_service.service.HandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    private final HandlerService handlerService;

    @Autowired
    public UserController(HandlerService handlerService) {
        this.handlerService = handlerService;
    }

    @PutMapping("/")
    public ResponseEntity<?> putUser(@RequestBody UserDto user) {
        return handlerService.putUser(user);
    }

    @GetMapping("/")
    public ResponseEntity<?> getUser() {
        return handlerService.getUser();
    }

    @GetMapping("/trainer/{name}")
    public ResponseEntity<?> getUserByName(@PathVariable String name) {
        return handlerService.getTrainer(name);
    }

}

