package com.example.carmanagement;

public class LoggedUser {
    private static String username;

    public static void setUsername(String u) {
        username = u;
    }

    public static String getUsername() {
        return username;
    }

    public static void logout() {
        username = null;
    }
}
