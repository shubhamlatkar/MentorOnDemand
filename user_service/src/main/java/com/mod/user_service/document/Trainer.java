package com.mod.user_service.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {
    @Id
    private String id;
    private String username;
    private String fullName;
    private String email;
    private String description;
    private String expertise;
    private String position;
    private String company;
    private Long phone;

    public Trainer(String username, String fullName, String email, String description, String expertise, String position, String company, Long phone) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.description = description;
        this.expertise = expertise;
        this.position = position;
        this.company = company;
        this.phone = phone;
    }
}
