package com.mod.user_service.service;

import com.mod.user_service.document.Trainer;
import com.mod.user_service.document.User;
import com.mod.user_service.document.payload.request.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class HandlerService {

    private final UserService userService;
    private final TrainerService trainerService;

    public HandlerService(UserService userService, TrainerService trainerService) {
        this.userService = userService;
        this.trainerService = trainerService;
    }

    public ResponseEntity<?> getUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TRAINER")))
            return ResponseEntity.ok(trainerService.getTrainer(SecurityContextHolder.getContext().getAuthentication().getName()));
        return ResponseEntity.ok(userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
    }

    public ResponseEntity<?> putUser(String jwt, UserDto user) {
        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TRAINER"))) {
            return ResponseEntity.ok(trainerService.put(new Trainer(
                    user.getUsername(),
                    user.getFullName(),
                    user.getEmail(),
                    user.getDescription(),
                    user.getExpertise(),
                    user.getPosition(),
                    user.getCompany(),
                    user.getPhone()
            )));
        }
        return ResponseEntity.ok(userService.put(new User(
                SecurityContextHolder.getContext().getAuthentication().getName(),
                user.getEmail(),
                user.getPhone(),
                user.getFullName()
        )));
    }

    public ResponseEntity<?> postUser(String jwt, UserDto user) {
        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TRAINER"))) {
            return ResponseEntity.ok(trainerService.post(new Trainer(
                    user.getUsername(),
                    user.getFullName(),
                    user.getEmail(),
                    user.getDescription(),
                    user.getExpertise(),
                    user.getPosition(),
                    user.getCompany(),
                    user.getPhone()
            )));
        }
        return ResponseEntity.ok(userService.post(new User(
                SecurityContextHolder.getContext().getAuthentication().getName(),
                user.getEmail(),
                user.getPhone(),
                user.getFullName()
        ), jwt));
    }

    public ResponseEntity<?> getTrainer(String username) {
        Trainer trainer = trainerService.getTrainer(username);
        if (trainer != null)
            return ResponseEntity.ok(trainer);
        else
            return ResponseEntity.notFound().build();
    }
}
