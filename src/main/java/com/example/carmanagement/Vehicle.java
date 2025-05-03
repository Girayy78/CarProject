package com.example.carmanagement;

public class Vehicle {
    private String licensePlate;
    private String vehicleType;
    private String model;
    private int yearOfManufacture;
    private String fuelType;

    Vehicle(String vehicleType, String licensePlate, String model, int yearOfManufacture, String fuelType) {
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.fuelType = fuelType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    public String getModel() {
        return model;
    }
    public String getVehicleType() {
        return vehicleType;
    }
    public String getFuelType() {
        return fuelType;
    }
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

}
