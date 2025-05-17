package com.example.carmanagement;

public class User {
    private int id;
    private String fullName;
    private String username;
    private String plate;
    private String password;

    public User(int id, String fullName, String username, String plate, String password) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.plate = plate;
        this.password = password;
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getUsername() { return username; }
    public String getPlate() { return plate; }
    public String getPassword() { return password; }
}
