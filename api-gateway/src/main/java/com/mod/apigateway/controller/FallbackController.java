package com.mod.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
    @GetMapping("/courseFallback")
    public Mono<String> courseFallback() {
        return Mono.just("Course service down");
    }

    @GetMapping("/userFallback")
    public Mono<String> userFallback() {
        return Mono.just("User service down");
    }

    @GetMapping("/userCourseFallback")
    public Mono<String> userCourseFallback() { return Mono.just("User-Course service down"); }

    @GetMapping("/authFallback")
    public Mono<String> authFallback() {
        return Mono.just("Auth service down");
    }
}
