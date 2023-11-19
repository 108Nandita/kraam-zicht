package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.Admin;
import com.project.kraamzicht.models.Client;
import com.project.kraamzicht.models.MaternityNurse;
import com.project.kraamzicht.models.Midwife;

import java.util.List;

public class AdminDto extends UserDto {
    private long personnelNumber;
    private List<MaternityNurseDto> createdMaternityNurses;
    private List<ClientDto> createdClients;
    private List<ClientFileDto> createdClientFiles;
    private List<MidwifeDto> createdMidwives;

    public long getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(long personnelNumber) {
        this.personnelNumber = personnelNumber;
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
        // Mapping from Admin to AdminDto
        dto.setPersonnelNumber(admin.getPersonnelNumber());
        // Map other properties as needed
        // Set common properties from User class
        dto.setUsername(admin.getUsername());
        dto.setPassword(admin.getPassword());
        dto.setEnabled(admin.isEnabled());
        dto.setApikey(admin.getApikey());
        dto.setEmail(admin.getEmail());
        dto.setAuthorities(admin.getAuthorities());
        dto.setName(admin.getName());
        dto.setSurname(admin.getSurname());
        dto.setDob(admin.getDob());
        dto.setAddress(admin.getAddress());
        dto.setPostalcode(admin.getPostalcode());
        dto.setPlace(admin.getPlace());
        dto.setPhoneNr(admin.getPhoneNr());
        dto.setRole(admin.getRole());

        return dto;
    }
}