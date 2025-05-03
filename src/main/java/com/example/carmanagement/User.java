package com.example.carmanagement;

public class User {

    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String role;

    User(String username, String password, String fullName, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;

        if (username.equals("admin") && password.equals("gaziprojeadmin")) {
            this.role = "admin";
        } else {
            this.role = "user";
        }

    }

    private String getUsername(){
        return username;
    }

    private String getPassword() {
        return password;
    }

    private String getFullName() {
        return fullName;
    }

    private String getEmail() {
        return email;
    }

    private String getPhoneNumber() {
        return phoneNumber;
    }

    private String getRole() {
        return  role;
    }

}
