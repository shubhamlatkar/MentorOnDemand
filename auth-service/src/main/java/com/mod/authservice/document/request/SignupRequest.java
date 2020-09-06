package com.mod.authservice.document.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String username;

    private String email;

    private Set<String> roles;

    private String password;

    private Long mobile;

}
