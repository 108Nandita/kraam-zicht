package com.project.kraamzicht.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Table(name = "clients")
@PrimaryKeyJoinColumn(name = "clientId")
@DiscriminatorValue("Client")
public class Client extends User {


    @Id
    @Column(unique = true, nullable = false)
    private String clientId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "admin_username", referencedColumnName = "username"),
            @JoinColumn(name = "admin_personnelNumber", referencedColumnName = "personnelNumber")
    })
    private Admin admin;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClientFile> clientFiles;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
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