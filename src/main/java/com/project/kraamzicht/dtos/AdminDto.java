package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.Admin;
import com.project.kraamzicht.dtos.UserDto;

import java.util.List;

public class AdminDto extends UserDto {

    private String username;
    private long personnelNumber;
    private boolean enabled;
    private List<MaternityNurseDto> createdMaternityNurses;
    private List<ClientDto> createdClients;
    private List<ClientFileDto> createdClientFiles;
    private List<MidwifeDto> createdMidwives;

    public AdminDto() {
        // Default constructor
    }

    public AdminDto(String username, long personnelNumber, boolean enabled, List<MaternityNurseDto> createdMaternityNurses, List<ClientDto> createdClients, List<ClientFileDto> createdClientFiles, List<MidwifeDto> createdMidwives) {
        this.username = username;
        this.personnelNumber = personnelNumber;
        this.enabled = enabled;
        this.createdMaternityNurses = createdMaternityNurses;
        this.createdClients = createdClients;
        this.createdClientFiles = createdClientFiles;
        this.createdMidwives = createdMidwives;
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

    public List<MaternityNurseDto> getCreatedMaternityNurses() {
        return createdMaternityNurses;
    }

    public void setCreatedMaternityNurses(List<MaternityNurseDto> createdMaternityNurses) {
        this.createdMaternityNurses = createdMaternityNurses;
    }

    public List<ClientDto> getCreatedClients() {
        return createdClients;
    }

    public void setCreatedClients(List<ClientDto> createdClients) {
        this.createdClients = createdClients;
    }

    public List<MidwifeDto> getCreatedMidwives() {
        return createdMidwives;
    }

    public void setCreatedMidwives(List<MidwifeDto> createdMidwives) {
        this.createdMidwives = createdMidwives;
    }

    public List<ClientFileDto> getCreatedClientFiles() {
        return createdClientFiles;
    }

    public void setCreatedClientFiles(List<ClientFileDto> createdClientFiles) {
        this.createdClientFiles = createdClientFiles;
    }

    public static AdminDto fromAdmin(Admin admin) {
        AdminDto dto = new AdminDto();
        dto.setUsername(admin.getUsername());
        dto.setPersonnelNumber(admin.getPersonnelNumber());
        dto.setEnabled(admin.isEnabled());
        dto.setApikey(admin.getApikey());
        dto.setEmail(admin.getEmail());
        dto.setRole(admin.getRole());
        dto.setName(admin.getName());
        dto.setSurname(admin.getSurname());
        dto.setDob(admin.getDob());
        dto.setAddress(admin.getAddress());
        dto.setPostalcode(admin.getPostalcode());
        dto.setPlace(admin.getPlace());
        dto.setPhoneNr(admin.getPhoneNr());


        return dto;
    }

    public Admin toAdmin() {
        Admin admin = new Admin();
        admin.setPersonnelNumber(this.getPersonnelNumber());
        admin.setEnabled(this.isEnabled());
        admin.setApikey(this.getApikey());
        admin.setEmail(this.getEmail());
        admin.setRole(this.getRole());
      //  admin.setAuthorities(this.getAuthorities());
        admin.setName(this.getName());
        admin.setSurname(this.getSurname());
        admin.setDob(this.getDob());
        admin.setAddress(this.getAddress());
        admin.setPostalcode(this.getPostalcode());
        admin.setPlace(this.getPlace());
        admin.setPhoneNr(this.getPhoneNr());
        return admin;
    }

}