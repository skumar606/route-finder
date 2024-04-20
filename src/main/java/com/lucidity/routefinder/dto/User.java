package com.lucidity.routefinder.dto;

public class User {
    private String firstName;
    private String lastName;
    private String contactNumber;

    public User(String firstName, String lastName, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
    }

    public User() {
    }
}
