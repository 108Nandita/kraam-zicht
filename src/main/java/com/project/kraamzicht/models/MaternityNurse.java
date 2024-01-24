package com.project.kraamzicht.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("MaternityNurse")
public class MaternityNurse extends User {

    @GeneratedValue
    @Column(name = "kckz_number", nullable = false, unique = true)
    private long kckzNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "admin_username", referencedColumnName = "username")
    private Admin createdByAdmin;

    @OneToMany(mappedBy = "maternityNurse", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClientFile> clientFiles;

    @OneToMany(mappedBy = "maternityNurse", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Indication> indications;

    public MaternityNurse() {
    }

    public MaternityNurse(List<Indication> indications) {
        this.indications = indications;
    }

    public long getKckzNumber() {
        return kckzNumber;
    }

    public void setKckzNumber(long kckzNumber) {
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}