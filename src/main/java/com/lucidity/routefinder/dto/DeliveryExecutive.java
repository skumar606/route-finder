package com.lucidity.routefinder.dto;

public class DeliveryExecutive extends User {
    private GeoLocation location;


    public DeliveryExecutive(String firstName, String lastName, String contactNumber, GeoLocation location) {
        super(firstName, lastName, contactNumber);
        this.location = location;
    }

    public DeliveryExecutive(GeoLocation deliveryExecutiveLocation) {
        this.location = deliveryExecutiveLocation;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "DeliveryExecutive{" +
                "location=" + location +
                '}';
    }
}
