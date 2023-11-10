package com.project.kraamzicht.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Midwife")
public class Midwife extends User {

    private long agbCode;
    private String certification;

    @OneToMany(mappedBy = "midwife")
    private List<ClientFile> clientFiles;

    @OneToMany(mappedBy = "midwife")
    private List<Indication> approvedIndications;

    public long getAgbCode() {
        return agbCode;
    }

    public void setAgbCode(long agbCode) {
        this.agbCode = agbCode;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public List<ClientFile> getClientFiles() {
        return clientFiles;
    }

    public void setClientFiles(List<ClientFile> clientFiles) {
        this.clientFiles = clientFiles;
    }

    public List<Indication> getApprovedIndications() {
        return approvedIndications;
    }

    public void setApprovedIndications(List<Indication> approvedIndications) {
        this.approvedIndications = approvedIndications;
    }
}
