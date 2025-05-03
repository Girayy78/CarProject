package com.example.carmanagement;

public class User {

    private String username;
    private String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String getUsername(){
        return username;
    }

    private String getPassword() {
        return password;
    }

}
