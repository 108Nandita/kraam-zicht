package com.project.kraamzicht.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Midwife")
public class Midwife extends User {


    @Column(name = "midwife_agb")
    private long agbCode;
    @Column
    private String certification;


    @ManyToOne
    @JoinColumn(name = "admin_username", referencedColumnName = "username")
    private Admin createdByAdmin;

    @OneToMany
    private List<Indication> approvedIndications;

    public Admin getCreatedByAdmin() {
        return createdByAdmin;
    }

    public void setCreatedByAdmin(Admin createdByAdmin) {
        this.createdByAdmin = createdByAdmin;
    }

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

    public List<Indication> getApprovedIndications() {
        return approvedIndications;
    }

    public void setApprovedIndications(List<Indication> approvedIndications) {
        this.approvedIndications = approvedIndications;
    }
}

