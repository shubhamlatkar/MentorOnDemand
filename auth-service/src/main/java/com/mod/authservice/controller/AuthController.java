package com.mod.authservice.controller;


import com.mod.authservice.document.auth.Authorities;
import com.mod.authservice.document.auth.Login;
import com.mod.authservice.document.auth.Role;
import com.mod.authservice.document.request.JwtResponse;
import com.mod.authservice.document.request.LoginRequest;
import com.mod.authservice.document.request.SignupRequest;
import com.mod.authservice.repository.AuthoritiesRepository;
import com.mod.authservice.repository.LoginRepository;
import com.mod.authservice.repository.RoleRepository;
import com.mod.authservice.security.config.PasswordConfig;
import com.mod.authservice.security.jwt.JwtTokenUtil;
import com.mod.authservice.security.services.UserDetailsImpl;
import com.mod.authservice.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;
    private final LoginRepository loginRepository;
    private final RoleRepository roleRepository;
    private final AuthoritiesRepository authoritiesRepository;
    private final PasswordConfig passwordConfig;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetails, JwtTokenUtil jwtTokenUtil, LoginRepository loginRepository, RoleRepository roleRepository, AuthoritiesRepository authoritiesRepository, PasswordConfig passwordConfig) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetails;
        this.jwtTokenUtil = jwtTokenUtil;
        this.loginRepository = loginRepository;
        this.roleRepository = roleRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.passwordConfig = passwordConfig;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@Valid @RequestBody SignupRequest signupRequest, BindingResult result) throws Exception {
        return (userDetailsService.saveUser(signupRequest) && !result.hasErrors()) ? ResponseEntity.ok().body("Saved") : ResponseEntity.badRequest().body("Bad Cerd");
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
    public ResponseEntity<JwtResponse> getJwtToken(@RequestBody LoginRequest request, HttpServletResponse response) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

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
        }

        final Cookie cookie = new Cookie("jwt", jwtToken);
        cookie.setMaxAge(24 * 60 * 60); // expires in 1 days
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        response.addCookie(cookie);

        return ResponseEntity.ok(new JwtResponse(jwtToken, userDetails.getId(), userDetails.getUsername()));
    }

    @GetMapping("/secured")
    public ResponseEntity<?> getTest() {
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

}