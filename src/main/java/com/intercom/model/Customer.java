package com.intercom.model;

public class Customer {
    private final int user_id;
    private String name;
    private Location location;

    public Customer(int user_id) {
        this.user_id = user_id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
