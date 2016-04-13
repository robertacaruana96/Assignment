package com.User;

/**
 * Created by leann on 13/04/2016.
 */
public class User {

    private String userId;
    private String name;
    private String surname;
    private int contactNumber;
    private String email;
    private String address;

    public User(String userId, String name, String surname, int contactNumber, String email, String address) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }

    public User() {
        this.userId = null;
        this.name = null;
        this.surname = null;
        this.contactNumber = 0;
        this.email = null;
        this.address = null;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
