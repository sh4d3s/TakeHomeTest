package com.intercom.model;

public class Customer {
    private int user_id;
    private String name;
    private Location location;

    public Customer(int user_id, String name, Location location) {

        this.user_id = user_id;
        this.name = name;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

}
