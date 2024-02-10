package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.models.Indication;
import com.project.kraamzicht.models.MaternityNurse;

import java.util.List;

public class MaternityNurseDto extends UserDto {

    private String username;
    private long kckzNumber;
    private List<ClientFile> clientFiles;
    private List<Indication> indications;

    public long getKckzNumber() {
        return kckzNumber;
    }

    public void setKckzNumber(long kckzNumber) {
        this.kckzNumber = kckzNumber;
    }

    public List<ClientFile> getClientFiles() {
        return clientFiles;
    }

    public void setClientFiles(List<ClientFile> clientFiles) {
        this.clientFiles = clientFiles;
    }

    public List<Indication> getIndications() {
        return indications;
    }

    public void setIndications(List<Indication> indications) {
        this.indications = indications;
    }

    public static MaternityNurseDto fromMaternityNurse(MaternityNurse maternityNurse) {
        MaternityNurseDto dto = new MaternityNurseDto();
        // Mapping from MaternityNurse to MaternityNurseDto
        dto.setUsername(maternityNurse.getUsername());
        dto.setKckzNumber(maternityNurse.getKckzNumber());
        dto.setClientFiles(maternityNurse.getClientFiles());
        dto.setIndications(maternityNurse.getIndications());
        dto.setEnabled(maternityNurse.isEnabled());
        dto.setApikey(maternityNurse.getApikey());
        dto.setEmail(maternityNurse.getEmail());
        dto.setName(maternityNurse.getName());
        dto.setSurname(maternityNurse.getSurname());
        dto.setDob(maternityNurse.getDob());
        dto.setAddress(maternityNurse.getAddress());
        dto.setPostalcode(maternityNurse.getPostalcode());
        dto.setPlace(maternityNurse.getPlace());
        dto.setPhoneNr(maternityNurse.getPhoneNr());

        return dto;
    }

    public static MaternityNurse toMaternityNurse(MaternityNurseDto dto) {
        MaternityNurse maternityNurse = new MaternityNurse();
        // Mapping from MaternityNurseDto to MaternityNurse
        maternityNurse.setUsername(dto.getUsername());
        maternityNurse.setKckzNumber(dto.getKckzNumber());
        maternityNurse.setClientFiles(dto.getClientFiles());
        maternityNurse.setIndications(dto.getIndications());
        maternityNurse.setEnabled(dto.isEnabled());
        maternityNurse.setApikey(dto.getApikey());
        maternityNurse.setEmail(dto.getEmail());
        maternityNurse.setName(dto.getName());
        maternityNurse.setSurname(dto.getSurname());
        maternityNurse.setDob(dto.getDob());
        maternityNurse.setAddress(dto.getAddress());
        maternityNurse.setPostalcode(dto.getPostalcode());
        maternityNurse.setPlace(dto.getPlace());
        maternityNurse.setPhoneNr(dto.getPhoneNr());

        return maternityNurse;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}