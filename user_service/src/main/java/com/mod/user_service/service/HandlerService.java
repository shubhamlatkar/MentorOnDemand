package com.mod.user_service.service;

import com.mod.user_service.document.Admin;
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
    private final AdminService adminService;

    public HandlerService(UserService userService, TrainerService trainerService, AdminService adminService) {
        this.userService = userService;
        this.trainerService = trainerService;
        this.adminService = adminService;
    }

    public ResponseEntity<?> getUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            return ResponseEntity.ok(adminService.get(SecurityContextHolder.getContext().getAuthentication().getName()));
        else if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TRAINER")))
            return ResponseEntity.ok(trainerService.getTrainer(SecurityContextHolder.getContext().getAuthentication().getName()));
        else
            return ResponseEntity.ok(userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
    }

    public ResponseEntity<?> putUser(UserDto user) {
        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            return ResponseEntity.ok(adminService.put(new Admin(null, user.getUsername(), user.getEmail(), user.getPhone(), user.getFullName(), user.getAddress())));
        else if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TRAINER")))
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
        else return ResponseEntity.ok(userService.put(new User(
                    SecurityContextHolder.getContext().getAuthentication().getName(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getFullName()
            )));
    }

    public ResponseEntity<?> getTrainer(String username) {
        Trainer trainer = trainerService.getTrainer(username);
        if (trainer != null)
            return ResponseEntity.ok(trainer);
        else
            return ResponseEntity.notFound().build();
    }
}
