package com.mod.user_service.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Trainer {
    @Id
    private String id;
    private String username;
    private String fullName;
    private String email;
    private String description;
    private String experties;
    private String position;
    private String company;
    private String phone;

    public Trainer() {
    }

    public Trainer(String username, String fullName, String email, String description, String experties, String position, String company, String phone) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.description = description;
        this.experties = experties;
        this.position = position;
        this.company = company;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperties() {
        return experties;
    }

    public void setExperties(String experties) {
        this.experties = experties;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", experties='" + experties + '\'' +
                ", position='" + position + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
