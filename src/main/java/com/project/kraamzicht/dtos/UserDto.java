package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.Authority;

import java.time.LocalDate;
import java.util.Set;

public class UserDto {
    private String username;
    private String password;
    public Boolean enabled;
    private String authority;
    private String name;
    private String surname;
    private LocalDate dob;
    private String address;
    private String postalcode;
    private String place;
    private String phoneNr;
    private String email;
    private String role;
    private String apikey;

    public UserDto() {
    }

    public UserDto(String username, String password, Boolean enabled, String authority,
                   String name, String surname, LocalDate dob, String address,
                   String postalcode, String place, String phoneNr, String email,
                   String role, String apikey, Set<Authority> authorities) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authority = authority;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.address = address;
        this.postalcode = postalcode;
        this.place = place;
        this.phoneNr = phoneNr;
        this.email = email;
        this.role = role;
        this.apikey = apikey;
        this.authorities = authorities;
    }

    public Set<Authority> authorities;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public Boolean getEnabled() {
        return enabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
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

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
