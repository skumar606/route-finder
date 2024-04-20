package com.lucidity.routefinder.dto;

public class Restaurant {
    private String id;
    private String name;
    private GeoLocation location;
    private String phoneNumber;

    private double averageFoodPreparationTime;

    public Restaurant(String id, String name, GeoLocation location, String phoneNumber, double averageFoodPreparationTime) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.averageFoodPreparationTime = averageFoodPreparationTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getAverageFoodPreparationTime() {
        return averageFoodPreparationTime;
    }

    public void setAverageFoodPreparationTime(double averageFoodPreparationTime) {
        this.averageFoodPreparationTime = averageFoodPreparationTime;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "location=" + location +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
