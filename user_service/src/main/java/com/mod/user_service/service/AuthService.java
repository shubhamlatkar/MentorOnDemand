package com.mod.user_service.service;

import com.mod.user_service.document.Admin;
import com.mod.user_service.document.Trainer;
import com.mod.user_service.document.User;
import com.mod.user_service.document.auth.Login;
import com.mod.user_service.document.payload.request.AuthEvent;
import com.mod.user_service.repository.auth.LoginRepository;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {
    private final LoginRepository loginRepository;
    private final UserService userService;
    private final TrainerService trainerService;
    private final AdminService adminService;

    public AuthService(LoginRepository loginRepository, UserService userService, TrainerService trainerService, AdminService adminService) {
        this.loginRepository = loginRepository;
        this.userService = userService;
        this.trainerService = trainerService;
        this.adminService = adminService;
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
        if (found != null && user.getRoles().stream().anyMatch(role -> role.getRole().equals("ADMIN")))
            adminService.put(new Admin(user.getId(), user.getUsername(), user.getEmail(), user.getMobileNumber(), null, null));
        else if (found != null && user.getRoles().stream().anyMatch(role -> role.getRole().equals("TRAINER")))
            trainerService.put(new Trainer(found.getId(), found.getUsername(), null, found.getEmail(), null, null, null, null, found.getMobileNumber()));
        else if (found != null && user.getRoles().stream().anyMatch(role -> role.getRole().equals("USER")))
            userService.put(new User(user.getUsername(), user.getEmail(), user.getMobileNumber(), null));

    }

    private void delete(String username) {
        Login user = loginRepository.findByUsername(username).orElse(null);
        if (user != null && user.getRoles().stream().anyMatch(role -> role.getRole().equals("ADMIN")))
            adminService.delete(username);
        else if (user != null && user.getRoles().stream().anyMatch(role -> role.getRole().equals("TRAINER")))
            trainerService.delete(username);
        else if (user != null && user.getRoles().stream().anyMatch(role -> role.getRole().equals("USER")))
            userService.delete(username);
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
            if (user.getRoles().stream().anyMatch(role -> role.getRole().equals("ADMIN")))
                adminService.post(new Admin(user.getId(), user.getUsername(), user.getEmail(), user.getMobileNumber(), null, null));
            else if (user.getRoles().stream().anyMatch(role -> role.getRole().equals("TRAINER")))
                trainerService.post(new Trainer(user.getId(), user.getUsername(), null, user.getEmail(), null, null, null, null, user.getMobileNumber()));
            else if (user.getRoles().stream().anyMatch(role -> role.getRole().equals("USER")))
                userService.post(new User(user.getId(), user.getUsername(), user.getEmail(), user.getMobileNumber(), null));
        }
    }
}
