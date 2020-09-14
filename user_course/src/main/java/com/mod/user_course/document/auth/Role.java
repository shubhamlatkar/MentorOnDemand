package com.mod.user_course.document.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private String id;
    private String role;
    private List<Authorities> authorities;

    public Role(String role) {
        this.role = role;
    }

    public void addAuthority(Authorities authority) {
        if (authorities == null) {
            authorities = new ArrayList<>();
        }
        authorities.add(authority);
    }
}
