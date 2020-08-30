package com.mod.authservice.service;

import com.mod.authservice.config.EventConfig;
import com.mod.authservice.document.auth.Login;
import com.mod.authservice.document.request.JwtResponse;
import com.mod.authservice.document.request.LoginRequest;
import com.mod.authservice.document.request.SignupRequest;
import com.mod.authservice.document.response.EventResponse;
import com.mod.authservice.repository.LoginRepository;
import com.mod.authservice.security.jwt.JwtTokenUtil;
import com.mod.authservice.security.services.UserDetailsImpl;
import com.mod.authservice.security.services.UserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsServiceImpl userDetailsService;
    private final LoginRepository loginRepository;
    private final EventConfig eventConfig;

    public AuthService(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserDetailsServiceImpl userDetailsService, LoginRepository loginRepository, EventConfig eventConfig) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.loginRepository = loginRepository;
        this.eventConfig = eventConfig;
    }

    public Boolean handleRequest(String username, String url, String jwt) {
        Login user = loginRepository.findByUsername(username).orElse(null);
        if (user != null) {
            List<String> activeTokens = user.getActiveTokens();
            if (!activeTokens.contains(jwt.toString()) && username != null)
                return false;
            if (url.contains("/logmeout")) {
                logout(jwt, user);
            } else if (url.contains("/logoutall")) {
                logoutAll(user);
            }
        }
        return true;
    }

    public void logout(String finalJwt, Login user) {

        List<String> activeTokens = user.getActiveTokens();

        activeTokens = activeTokens.stream().filter(token -> {
            boolean isTokePresent = token.toString().equals(finalJwt.toString());
            return !(isTokePresent);
        }).collect(Collectors.toList());
        user.setActiveTokens(activeTokens);
        loginRepository.save(user);
        eventConfig.ModAuth().send(MessageBuilder.withPayload(new EventResponse("logout", null, finalJwt,user.getUsername())).build());
    }

    public void logoutAll(Login user) {
        user.setActiveTokens(new ArrayList<>());
        loginRepository.save(user);
        eventConfig.ModAuth().send(MessageBuilder.withPayload(new EventResponse("logoutAll", null, null, user.getUsername())).build());
    }

    public ResponseEntity<?> getAllUsers() {
//        Authorities read = new Authorities("user:read");
//        Authorities write = new Authorities("user:write");
//        authoritiesRepository.save(read);
//        authoritiesRepository.save(write);
//
//        Role trainerRole = new Role("TRAINER");
//        trainerRole.addAuthority(authoritiesRepository.findByAuthority("course:read").orElse(null));
//        trainerRole.addAuthority(authoritiesRepository.findByAuthority("course:write").orElse(null));
//
//        roleRepository.save(trainerRole);
//
//        Role adminRole = roleRepository.findByRole("ADMIN").orElse(null);
//        if(adminRole != null) {
//            adminRole.addAuthority(authoritiesRepository.findByAuthority("user:read").orElse(null));
//            adminRole.addAuthority(authoritiesRepository.findByAuthority("user:write").orElse(null));
//            roleRepository.save(adminRole);
//        }
//        Login shu = new Login("shu","shu@shu.com",passwordConfig.passwordEncoder().encode("12as"));
//        shu.addRole(roleRepository.findByRole("ADMIN").orElse(null));
//        loginRepository.save(shu);
//
//        Login knu = new Login("knu","knu@shu.com",passwordConfig.passwordEncoder().encode("12as"));
//        knu.addRole(roleRepository.findByRole("USER").orElse(null));
//        loginRepository.save(knu);
//
//        Login ps = new Login("ps","ps@shu.com",passwordConfig.passwordEncoder().encode("12as"));
//        ps.addRole(roleRepository.findByRole("TRAINER").orElse(null));
//        loginRepository.save(ps);

        return ResponseEntity.ok(loginRepository.findAll());
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
            eventConfig.ModAuth().send(MessageBuilder.withPayload(new EventResponse("login", null, jwtToken, user.getUsername())).build());
        }


        return ResponseEntity.ok(new JwtResponse(jwtToken, userDetails.getId(), userDetails.getUsername()));
    }
}
