package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.models.Indication;
import com.project.kraamzicht.models.MaternityNurse;

import java.util.List;

public class MaternityNurseDto extends UserDto {
    private String kckzNumber;
    private List<ClientFile> clientFiles;
    private List<Indication> indications;

    public String getKckzNumber() {
        return kckzNumber;
    }

    public void setKckzNumber(String kckzNumber) {
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
}