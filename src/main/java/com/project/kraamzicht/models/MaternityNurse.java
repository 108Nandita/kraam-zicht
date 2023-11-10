package com.project.kraamzicht.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@DiscriminatorValue("MaternityNurse")
public class MaternityNurse extends User {

    @Id
    private String kzkzNumber;

    @OneToMany(mappedBy = "maternityNurse")
    private List<ClientFile> clientFiles;

    public String getKzkzNumber() {
        return kzkzNumber;
    }

    public void setKzkzNumber(String kzkzNumber) {
        this.kzkzNumber = kzkzNumber;
    }

    public List<ClientFile> getClientFiles() {
        return clientFiles;
    }

    public void setClientFiles(List<ClientFile> clientFiles) {
        this.clientFiles = clientFiles;
    }
}