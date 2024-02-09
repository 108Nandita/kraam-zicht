package com.project.kraamzicht.dtos;

import java.time.LocalDate;

public class UserDetailsDto {
    private String name;
    private String surname;
    private LocalDate dob;
    private String address;
    private String postalcode;
    private String place;

    public UserDetailsDto() {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.address = address;
        this.postalcode = postalcode;
        this.place = place;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
