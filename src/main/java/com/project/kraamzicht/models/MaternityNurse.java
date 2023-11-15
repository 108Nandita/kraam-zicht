package com.project.kraamzicht.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("MaternityNurse")
public class MaternityNurse extends User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "kckz_number", nullable = false, unique = true)
    private String kckzNumber;


    @ManyToOne
    @JoinColumn(name = "admin_username", referencedColumnName = "username")
    private Admin createdByAdmin;

    @OneToMany
    private List<ClientFile> clientFiles;


    @OneToMany
    private List<Indication> indications;

    public MaternityNurse() {
    }

    public Admin getCreatedByAdmin() {
        return createdByAdmin;
    }

    public void setCreatedByAdmin(Admin createdByAdmin) {
        this.createdByAdmin = createdByAdmin;
    }

    public MaternityNurse(List<Indication> indications) {
        this.indications = indications;
    }

    public String getKckzNumber() {
        return kckzNumber;
    }

    public void setKckzNumber(String kckzNumber) {
        this.kckzNumber = kckzNumber;
    }


    public List<Indication> getIndications() {
        return indications;
    }

    public void setIndications(List<Indication> indications) {
        this.indications = indications;
    }

    public List<ClientFile> getClientFiles() {
        return clientFiles;
    }

    public void setClientFiles(List<ClientFile> clientFiles) {
        this.clientFiles = clientFiles;
    }
}

