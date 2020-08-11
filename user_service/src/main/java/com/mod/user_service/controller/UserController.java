package com.mod.user_service.controller;

import com.mod.user_service.document.payload.request.UserDto;
import com.mod.user_service.service.HandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/user/")
public class UserController {

    private final HandlerService handlerService;

    @Autowired
    public UserController(HandlerService handlerService) {
        this.handlerService = handlerService;
    }

    @PutMapping("/")
    public ResponseEntity<?> putUser(HttpServletRequest httpServletRequest, @RequestBody UserDto user) {
        final String authorization = httpServletRequest.getHeader("Authorization");
        String jwt = null;
        if (authorization != null && authorization.startsWith("Bearer ")) {
            jwt = authorization.substring(7);
            return handlerService.putUser(jwt, user);
        }
        return ResponseEntity.badRequest().body("Unauthorized");
    }

    @GetMapping("/")
    public ResponseEntity<?> getUser() {
        return handlerService.getUser();
    }

    @GetMapping("/trainer/{name}")
    public ResponseEntity<?> getUserByName(@PathVariable String name) {
        return handlerService.getTrainer(name);
    }

    @PostMapping("/")
    public ResponseEntity<?> postUser(HttpServletRequest httpServletRequest, @RequestBody UserDto user) {
        final String authorization = httpServletRequest.getHeader("Authorization");
        String jwt = null;
        if (authorization != null && authorization.startsWith("Bearer ")) {
            jwt = authorization.substring(7);
            return handlerService.postUser(jwt, user);
        }
        return ResponseEntity.badRequest().body("Unauthorized");
    }


}

