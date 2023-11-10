package com.project.kraamzicht.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@DiscriminatorValue("Client")
public class Client extends User {

    private String clientId;

    @OneToMany(mappedBy = "client")
    private List<ClientFile> clientFiles;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}