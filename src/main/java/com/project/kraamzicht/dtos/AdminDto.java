package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.Admin;
import com.project.kraamzicht.dtos.UserDto;

import java.util.List;

public class AdminDto extends UserDto {

    private String username;
    private long personnelNumber;
    private boolean enabled;

    public AdminDto() {
    }

    public AdminDto(String username, long personnelNumber, boolean enabled) {
        this.username = username;
        this.personnelNumber = personnelNumber;
        this.enabled = enabled;

    }

    public long getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(long personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public boolean isEnabled() {
        return enabled;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public static AdminDto fromAdmin(Admin admin) {
        AdminDto dto = new AdminDto();
        dto.setUsername(admin.getUsername());
        dto.setPersonnelNumber(admin.getPersonnelNumber());
        dto.setEnabled(admin.isEnabled());
        dto.setApikey(admin.getApikey());
        dto.setEmail(admin.getEmail());
        dto.setName(admin.getName());
        dto.setSurname(admin.getSurname());
        dto.setDob(admin.getDob());
        dto.setAddress(admin.getAddress());
        dto.setPostalcode(admin.getPostalcode());
        dto.setPlace(admin.getPlace());
        dto.setPhoneNr(admin.getPhoneNr());

        return dto;
    }

    public static Admin toAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setUsername(adminDto.getUsername());
        admin.setPersonnelNumber(adminDto.getPersonnelNumber());
        admin.setEnabled(adminDto.isEnabled());
        admin.setApikey(adminDto.getApikey());
        admin.setEmail(adminDto.getEmail());
        admin.setName(adminDto.getName());
        admin.setSurname(adminDto.getSurname());
        admin.setDob(adminDto.getDob());
        admin.setAddress(adminDto.getAddress());
        admin.setPostalcode(adminDto.getPostalcode());
        admin.setPlace(adminDto.getPlace());
        admin.setPhoneNr(adminDto.getPhoneNr());
        return admin;
    }

}