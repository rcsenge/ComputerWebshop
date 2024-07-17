package org.example.model;

public class Customer {
    private final int id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;

    public Customer(int id, String username, String firstName, String lastName, String email, String address) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
