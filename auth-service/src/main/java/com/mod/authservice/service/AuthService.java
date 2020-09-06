package com.mod.authservice.service;

import com.mod.authservice.bean.UserBean;
import com.mod.authservice.config.EventConfig;
import com.mod.authservice.document.auth.Login;
import com.mod.authservice.document.request.*;
import com.mod.authservice.document.response.EventResponse;
import com.mod.authservice.repository.AuthoritiesRepository;
import com.mod.authservice.repository.LoginRepository;
import com.mod.authservice.repository.RoleRepository;
import com.mod.authservice.security.config.PasswordConfig;
import com.mod.authservice.security.jwt.JwtTokenUtil;
import com.mod.authservice.security.services.UserDetailsImpl;
import com.mod.authservice.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsServiceImpl userDetailsService;
    private final LoginRepository loginRepository;
    private final EventConfig eventConfig;
    private final PasswordConfig passwordConfig;
    private final UserBean userBean;

    @Autowired
    private AuthoritiesRepository authoritiesRepository;
    @Autowired
    private RoleRepository roleRepository;

    public AuthService(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserDetailsServiceImpl userDetailsService, LoginRepository loginRepository, EventConfig eventConfig, PasswordConfig passwordConfig, UserBean userBean) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.loginRepository = loginRepository;
        this.eventConfig = eventConfig;
        this.passwordConfig = passwordConfig;
        this.userBean = userBean;
    }

    public Boolean handleRequest(String username, String url, String jwt) {
        Login user = loginRepository.findByUsername(username).orElse(null);
        if (user != null) {
            List<String> activeTokens = user.getActiveTokens();
            if (!activeTokens.contains(jwt.toString()) && username != null)
                return false;
            else if (url.contains("/logmeout"))
                logout(jwt, user);
            else if (url.contains("/logoutall"))
                logoutAll(user);
            userBean.setUser(user);
            userBean.setJwt(jwt);
        }
        return true;
    }

    public void delete() {
        loginRepository.delete(userBean.getUser());
        eventConfig.ModAuth().send(MessageBuilder.withPayload(new EventResponse("DELETE", null, null, userBean.getUser().getUsername())).build());
    }

    public ResponseEntity<?> changePwd(ChangePwd changePwd) {
        Login user = loginRepository.findByUsername(changePwd.getUsername()).orElse(null);
        if (user != null && user.getPassword().equals(passwordConfig.passwordEncoder().encode(changePwd.getOldPassword()))) {
            user.setActiveTokens(new ArrayList<>());
            user.setPassword(passwordConfig.passwordEncoder().encode(changePwd.getNewPassword()));
            loginRepository.save(user);
            eventConfig.ModAuth().send(MessageBuilder.withPayload(new EventResponse("CHANGE_PWD", user, null, user.getUsername())).build());
            return ResponseEntity.status(HttpStatus.OK).body("Updated....");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found.....");
    }

    public ResponseEntity<?> resetPwd(ResetPwd resetPwd) {
        Login user = loginRepository.findByUsername(resetPwd.getUsername()).orElse(null);
        if (user != null) {
            user.setActiveTokens(new ArrayList<>());
            user.setPassword(passwordConfig.passwordEncoder().encode(resetPwd.getPassword()));
            loginRepository.save(user);
            eventConfig.ModAuth().send(MessageBuilder.withPayload(new EventResponse("CHANGE_PWD", user, null, user.getUsername())).build());
            return ResponseEntity.status(HttpStatus.OK).body("Updated....");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found.....");
    }

    public ResponseEntity<?> patch(PatchUser patchUser) {
        Login user = loginRepository.findByUsername(patchUser.getUsername()).orElse(null);
        if (user != null) {
            user.setActiveTokens(new ArrayList<>());
            user.setEmail(patchUser.getEmail());
            user.setMobileNumber(patchUser.getMobileNumber());
            loginRepository.save(user);
            eventConfig.ModAuth().send(MessageBuilder.withPayload(new EventResponse("PATCH", user, null, user.getUsername())).build());
            return ResponseEntity.status(HttpStatus.OK).body("Updated....");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found.....");
    }

    public void logout(String finalJwt, Login user) {
        List<String> activeTokens = user.getActiveTokens();
        activeTokens = activeTokens.stream().filter(token -> {
            boolean isTokePresent = token.toString().equals(finalJwt.toString());
            return !(isTokePresent);
        }).collect(Collectors.toList());
        user.setActiveTokens(activeTokens);
        loginRepository.save(user);
        eventConfig.ModAuth().send(MessageBuilder.withPayload(new EventResponse("LOGOUT", null, finalJwt, user.getUsername())).build());
    }

    public void logoutAll(Login user) {
        user.setActiveTokens(new ArrayList<>());
        loginRepository.save(user);
        eventConfig.ModAuth().send(MessageBuilder.withPayload(new EventResponse("LOGOUT_ALL", null, null, user.getUsername())).build());
    }

    public ResponseEntity<?> getAllUsers() {
//        Authorities userRead = new Authorities("user:read");
//        Authorities userWrite = new Authorities("user:write");
//        authoritiesRepository.save(userRead);
//        authoritiesRepository.save(userWrite);
//
//        Authorities courseRead = new Authorities("course:read");
//        Authorities courseWrite = new Authorities("course:write");
//        authoritiesRepository.save(courseRead);
//        authoritiesRepository.save(courseWrite);
//
//        Role trainerRole = new Role("TRAINER");
//        trainerRole.addAuthority(authoritiesRepository.findByAuthority("course:read").orElse(null));
//        trainerRole.addAuthority(authoritiesRepository.findByAuthority("course:write").orElse(null));
//
//        Role adminRole = new Role("ADMIN");
//        adminRole.addAuthority(authoritiesRepository.findByAuthority("course:read").orElse(null));
//        adminRole.addAuthority(authoritiesRepository.findByAuthority("course:write").orElse(null));
//        adminRole.addAuthority(authoritiesRepository.findByAuthority("user:read").orElse(null));
//        adminRole.addAuthority(authoritiesRepository.findByAuthority("user:write").orElse(null));
//
//        Role userRole = new Role("USER");
//        userRole.addAuthority(authoritiesRepository.findByAuthority("course:read").orElse(null));
//        userRole.addAuthority(authoritiesRepository.findByAuthority("user:read").orElse(null));
//
//        roleRepository.saveAll(Arrays.asList(trainerRole, userRole, adminRole));

        return ResponseEntity.ok(Arrays.asList(loginRepository.findAll(), roleRepository.findAll(), authoritiesRepository.findAll()));
    }

    public Boolean signup(SignupRequest signupRequest) {
        return userDetailsService.saveUser(signupRequest);
    }

    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body("Bad cred");
        }

        final UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(
                request.getUsername()
        );

        final String jwtToken = jwtTokenUtil.generateToken(userDetails);
        Login user = loginRepository.findByUsername(request.getUsername()).orElse(null);

        List<String> tokens = user != null && user.getActiveTokens() != null ? user.getActiveTokens() : new ArrayList<>();
        tokens.add(jwtToken);
        if (user != null) {
            user.setActiveTokens(tokens);
            loginRepository.save(user);
            eventConfig.ModAuth().send(MessageBuilder.withPayload(new EventResponse("LOGIN", null, jwtToken, user.getUsername())).build());
        }
        return ResponseEntity.ok(new JwtResponse(jwtToken, userDetails.getId(), userDetails.getUsername()));
    }
}
