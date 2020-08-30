package com.mod.course_service.service;

import com.mod.course_service.document.auth.Login;
import com.mod.course_service.document.request.AuthEvent;
import com.mod.course_service.repository.auth.LoginRepository;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final LoginRepository loginRepository;

    public AuthService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @StreamListener(target = "ModAuth")
    public void authConsumer(AuthEvent event) {
        switch (event.getEventType()) {
            case "login":
                login(event.getToken(), event.getUsername());
                break;
            case "signup":
                signup(event.getUser());
                break;
            case "logout":
                logout(event.getToken(), event.getUsername());
                break;
            case "logoutAll":
                logoutAll(event.getToken(), event.getUsername());
                break;
            default:
                break;
        }
    }

    private void logout(String jwt, String username) {
        Login user = loginRepository.findByUsername(username).orElse(null);
        if (user != null) {
            List<String> activeTokens = user.getActiveTokens();

            activeTokens = activeTokens.stream().filter(token -> {
                boolean isTokePresent = token.toString().equals(jwt.toString());
                return !(isTokePresent);
            }).collect(Collectors.toList());
            user.setActiveTokens(activeTokens);
            loginRepository.save(user);
        }
    }

    private void login(String jwt, String username) {
        Login user = loginRepository.findByUsername(username).orElse(null);
        List<String> tokens = user != null && user.getActiveTokens() != null ? user.getActiveTokens() : new ArrayList<>();
        tokens.add(jwt);
        if (user != null) {
            user.setActiveTokens(tokens);
            loginRepository.save(user);
        }
    }

    private void logoutAll(String jwt, String username) {
        Login user = loginRepository.findByUsername(username).orElse(null);
        if (user != null) {
            user.setActiveTokens(new ArrayList<>());
            loginRepository.save(user);
        }
    }

    private void signup(Login user) {
        if (!loginRepository.existsByUsername(user.getUsername()))
            loginRepository.save(user);
    }
}
