package com.project.kraamzicht.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Indication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String indicationDescription;
    private int hoursNeeded;
    private boolean approved;

    private LocalDate indicationDate;
    private LocalDate approvalDate;

    @ManyToOne
    @JoinColumn(name = "client_file_id")
    private ClientFile clientFile;

    @ManyToOne
    @JoinColumn(name = "midwife_agb")
    private Midwife midwife;

    public Long getId() {
        return id;
    }

    public String getIndicationDescription() {
        return indicationDescription;
    }

    public void setIndicationDescription(String indicationDescription) {
        this.indicationDescription = indicationDescription;
    }

    public int getHoursNeeded() {
        return hoursNeeded;
    }

    public void setHoursNeeded(int hoursNeeded) {
        this.hoursNeeded = hoursNeeded;
    }

    public boolean getApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public LocalDate getIndicationDate() {
        return indicationDate;
    }

    public void setIndicationDate(LocalDate indicationDate) {
        this.indicationDate = indicationDate;
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDate approvalDate) {
        this.approvalDate = approvalDate;
    }

    public ClientFile getClientFile() {
        return clientFile;
    }

    public void setClientFile(ClientFile clientFile) {
        this.clientFile = clientFile;
    }

    public Midwife getMidwife() {
        return midwife;
    }

    public void setMidwife(Midwife midwife) {
        this.midwife = midwife;
    }
}