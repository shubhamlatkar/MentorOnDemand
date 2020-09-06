package com.mod.authservice.document.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    @Indexed(unique = true)
    private String email;
    private String password;
    private List<Role> roles;
    private List<String> activeTokens;
    private Long mobileNumber;

    public Login(String username, String email, String password, Long mobileNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    public void addRole(Role role) {
        if(roles == null)
            roles = new ArrayList<>();
        roles.add(role);
    }

    public void addToken(String token) {
        if(activeTokens == null)
            activeTokens = new ArrayList<>();
        activeTokens.add(token);
    }
}
