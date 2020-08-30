package com.mod.authservice.document.response;

import com.mod.authservice.document.auth.Login;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {
    private String eventType;
    private Login user;
    private String token;
    private String username;
}
