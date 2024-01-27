package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.User;

import java.time.LocalDate;
import java.util.Set;

public class UserDto {
    private String name;
    private String surname;
    private LocalDate dob;
    private String address;
    private String postalcode;
    private String place;
    private String phoneNr;
    private String email;

    private String role;

    private boolean enabled = true;
    private String apikey;
    private Set<UserEntityDto> authorities;

    public UserDto() {

    }

    public UserDto(String name, String surname,
                   LocalDate dob, String address, String postalcode, String place, String phoneNr,
                   String email, String role,  boolean enabled, String apikey,
                   Set<UserEntityDto> authorities) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.address = address;
        this.postalcode = postalcode;
        this.place = place;
        this.phoneNr = phoneNr;
        this.email = email;
        this.role = role;
        this.enabled = enabled;
        this.apikey = apikey;
        this.authorities = authorities;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public Set<UserEntityDto> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<UserEntityDto> authorities) {
        this.authorities = authorities;
    }

    public static UserDto fromUser(User user) {
        UserDto dto = new UserDto();
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setDob(user.getDob());
        dto.setAddress(user.getAddress());
        dto.setPostalcode(user.getPostalcode());
        dto.setPlace(user.getPlace());
        dto.setPhoneNr(user.getPhoneNr());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setEnabled(user.isEnabled());
        dto.setApikey(user.getApikey());

        return dto;
    }

    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setDob(userDto.getDob());
        user.setAddress(userDto.getAddress());
        user.setPostalcode(userDto.getPostalcode());
        user.setPlace(userDto.getPlace());
        user.setPhoneNr(userDto.getPhoneNr());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        user.setEnabled(userDto.isEnabled());
        user.setApikey(userDto.getApikey());


        return user;
    }
}