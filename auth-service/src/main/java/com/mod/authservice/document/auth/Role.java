package com.mod.authservice.document.auth;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Role {
    @Id
    private String id;
    @Indexed(unique = true)
    private String role;
    private List<Authorities> authorities;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    public void addAuthority(Authorities authority) {
        if(authorities == null) {
            authorities = new ArrayList<>();
        }
        authorities.add(authority);
    }
}
