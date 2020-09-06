package com.mod.authservice.document.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchUser {
    private  String username;
    private String email;
    private  Long mobileNumber;
}
