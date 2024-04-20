package com.lucidity.routefinder.dto;

public class Consumer extends User {
    private String id;
    private GeoLocation location;

    public Consumer(String id, String firstName, String lastName, String contactNumber, GeoLocation location) {
        super(firstName, lastName, contactNumber);
        this.id = id;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id='" + id + '\'' +
                ", location=" + location +
                '}';
    }
}
