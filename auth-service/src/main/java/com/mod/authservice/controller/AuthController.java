package com.mod.authservice.controller;

import com.mod.authservice.document.request.*;
import com.mod.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@Valid @RequestBody SignupRequest signupRequest, BindingResult result) throws Exception {
        return (authService.signup(signupRequest) && !result.hasErrors()) ? ResponseEntity.ok().body("Saved") : ResponseEntity.badRequest().body("Bad Cerd");
    }

    @GetMapping("/tryAutoLogin")
    public ResponseEntity<?> tryAutoLogin() {
        return ResponseEntity.ok().body("Authenticated");
    }

    @GetMapping("/logmeout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok().body("logged out....");
    }

    @GetMapping("/logoutall")
    public ResponseEntity<?> logoutAll() {
        return ResponseEntity.ok().body("logged out from all sessions....");
    }

    @PostMapping("/login")
    public ResponseEntity<?> getJwtToken(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUsers() {
        return authService.getAllUsers();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteMe() {
        authService.delete();
        return ResponseEntity.status(HttpStatus.OK).body("Deleted.....");
    }

    @PatchMapping("/")
    public ResponseEntity<?> patchMe(@RequestBody PatchUser patchUser) {
        return authService.patch(patchUser);
    }

    @PutMapping("/changePwd")
    public ResponseEntity<?> changePwd(@RequestBody ChangePwd changePwd) {
        return authService.changePwd(changePwd);
    }

    @PutMapping("/resetPwd")
    public ResponseEntity<?> resetPwd(@RequestBody ResetPwd resetPwd) {
        return authService.resetPwd(resetPwd);
    }
}