package com.mod.authservice.security.services;


import com.mod.authservice.config.EventConfig;
import com.mod.authservice.document.auth.Authorities;
import com.mod.authservice.document.auth.Login;
import com.mod.authservice.document.auth.Role;
import com.mod.authservice.document.request.SignupRequest;
import com.mod.authservice.document.response.EventResponse;
import com.mod.authservice.repository.AuthoritiesRepository;
import com.mod.authservice.repository.LoginRepository;
import com.mod.authservice.repository.RoleRepository;
import com.mod.authservice.security.config.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    LoginRepository loginRepository;
    @Autowired
    AuthoritiesRepository authoritiesRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private EventConfig kafkaConfig;

    private final PasswordConfig passwordConfig;

    @Autowired
    public UserDetailsServiceImpl(PasswordConfig passwordConfig) {
        this.passwordConfig = passwordConfig;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login user = loginRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
                .collect(Collectors.toSet());


        user.getRoles().forEach(role -> {
            for (Authorities authorities1 : role.getAuthorities()) {
                authorities.add(new SimpleGrantedAuthority(authorities1.getAuthority()));
            }
        });

        return UserDetailsImpl.build(user);
    }

    public Boolean saveUser(SignupRequest signupRequest) {
        if (loginRepository.existsByUsername(signupRequest.getUsername()) || loginRepository.existsByEmail(signupRequest.getEmail()))
            return false;

        List<Role> roles = signupRequest
                .getRoles()
                .stream()
                .map(role -> roleRepository.findByRole(role.substring(5)).orElse(null))
                .collect(Collectors.toList());

        Login user = new Login(
                signupRequest.getUsername(),
                signupRequest.getEmail(),
                passwordConfig.passwordEncoder().encode(signupRequest.getPassword()),
                signupRequest.getMobile()
        );
        user.setRoles(roles);
        loginRepository.save(user);
        kafkaConfig.ModAuth().send(MessageBuilder.withPayload(new EventResponse("SIGNUP", user, null, null)).build());

        return true;
    }

}