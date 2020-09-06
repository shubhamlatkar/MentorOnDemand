package com.mod.user_service.document.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;
    private String fullName;
    private String email;
    private String description;
    private String expertise;
    private String position;
    private String company;
    private Long phone;
    private String address;
}
