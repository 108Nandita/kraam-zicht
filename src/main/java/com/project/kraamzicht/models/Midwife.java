package com.project.kraamzicht.models;

import jakarta.persistence.Entity;

@Entity
public class Midwife extends User {

    private long agbCode;
    private String certification;

    public long getAgbCode() {
        return agbCode;
    }

    public void setMidwifeId(long agbCode) {
        this.agbCode = agbCode;
    }

    }
}