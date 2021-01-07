package com.mod.apigateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
    @GetMapping("/courseFallback")
    public Mono<ResponseEntity<?>> courseFallback() {
        return Mono.just(new ResponseEntity<String>("Course service down", HttpStatus.SERVICE_UNAVAILABLE));
    }

    @GetMapping("/userFallback")
    public Mono<ResponseEntity<?>> userFallback() {
        return Mono.just(new ResponseEntity<String>("User service down", HttpStatus.SERVICE_UNAVAILABLE));
    }

    @GetMapping("/userCourseFallback")
    public Mono<ResponseEntity<?>> userCourseFallback() {
        return Mono.just(new ResponseEntity<String>("User-Course service down", HttpStatus.SERVICE_UNAVAILABLE));
    }

    @GetMapping("/authFallback")
    public Mono<ResponseEntity<?>> authFallback() {
        return Mono.just(new ResponseEntity<String>("Auth service down", HttpStatus.SERVICE_UNAVAILABLE));
    }
}
