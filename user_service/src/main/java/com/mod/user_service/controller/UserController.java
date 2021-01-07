package com.mod.user_service.controller;

import com.mod.user_service.document.payload.request.UserDto;
import com.mod.user_service.service.HandlerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    private final HandlerService handlerService;

    @Autowired
    public UserController(HandlerService handlerService) {
        this.handlerService = handlerService;
    }

    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    @PutMapping("/")
    public ResponseEntity<?> putUser(@RequestBody UserDto user) {
        return handlerService.putUser(user);
    }

    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    @GetMapping("/")
    public ResponseEntity<?> getUser() {
        return handlerService.getUser();
    }

    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    @GetMapping("/trainer/{name}")
    public ResponseEntity<?> getUserByName(@PathVariable String name) {
        return handlerService.getTrainer(name);
    }

}

