package com.mod.user_service.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    @NotNull
    @Indexed(unique = true)
    private String username;
    @NotNull
    @Email
    private String email;
    private Long mobile;
    private String fullName;

    public User(@NotNull String username, @NotNull @Email String email, Long mobile, String fullName) {
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.fullName = fullName;
    }
}
