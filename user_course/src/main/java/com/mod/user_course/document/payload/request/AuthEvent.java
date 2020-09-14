package com.mod.user_course.document.payload.request;

import com.mod.user_course.document.auth.Login;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthEvent {
    private String eventType;
    private Login user;
    private String token;
    private String username;
}