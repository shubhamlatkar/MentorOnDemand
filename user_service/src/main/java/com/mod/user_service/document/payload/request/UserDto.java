package com.mod.user_service.document.payload.request;

public class UserDto {
    private String username;
    private String fullName;
    private String email;
    private String description;
    private String expertise;
    private String position;
    private String company;
    private String phone;

    public UserDto() {
    }

    public UserDto(String username, String fullName, String email, String description, String expertise, String position, String company, String phone) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.description = description;
        this.expertise = expertise;
        this.position = position;
        this.company = company;
        this.phone = phone;
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

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
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
        return "UserDto{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", experties='" + expertise + '\'' +
                ", position='" + position + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
