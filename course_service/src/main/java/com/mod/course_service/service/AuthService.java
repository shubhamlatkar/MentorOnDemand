package com.mod.course_service.service;

import com.mod.course_service.document.auth.Login;
import com.mod.course_service.document.request.AuthEvent;
import com.mod.course_service.repository.auth.LoginRepository;
import org.springframework.cloud.stream.annotation.StreamListener;
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
            case "LOGIN":
                login(event.getToken(), event.getUsername());
                break;
            case "SIGNUP":
                signup(event.getUser());
                break;
            case "LOGOUT":
                logout(event.getToken(), event.getUsername());
                break;
            case "LOGOUT_ALL":
                logoutAll(event.getUsername());
                break;
            case "DELETE":
                delete(event.getUsername());
                break;
            case "PATCH":
            case "CHANGE_PWD":
                patch(event.getUser());
            default:
                break;
        }
    }

    private void patch(Login user) {
        Login found = loginRepository.findByUsername(user.getUsername()).orElse(null);
        if (found != null)
            found = loginRepository.save(user);
    }

    private void delete(String username) {
        Login user = loginRepository.findByUsername(username).orElse(null);
        if (user != null)
            loginRepository.delete(user);
    }

    private void logout(String jwt, String username) {
        Login user = loginRepository.findByUsername(username).orElse(null);
        if (user != null) {
            List<String> activeTokens = user.getActiveTokens();
            activeTokens = activeTokens.stream().filter(token -> {
                boolean isTokePresent = token.equals(jwt);
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

    private void logoutAll(String username) {
        Login user = loginRepository.findByUsername(username).orElse(null);
        if (user != null) {
            user.setActiveTokens(new ArrayList<>());
            loginRepository.save(user);
        }
    }

    private void signup(Login user) {
        if (!loginRepository.existsByUsername(user.getUsername())) {
            loginRepository.save(user);
        }
    }
}
