package com.mod.authservice.bean;

import com.mod.authservice.document.auth.Login;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {
    private String jwt;
    private Login user;
}
