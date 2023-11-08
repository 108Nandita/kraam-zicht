package com.project.kraamzicht.models;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Client extends User {
    private String clientId;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}