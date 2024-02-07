package com.project.kraamzicht.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Indication {
    @Id
    @Column(name = "indication_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long indicationId;

    private String indicationDescription;
    private int hoursNeeded;
    private boolean approved;

    private LocalDate indicationDate;
    private LocalDate approvalDate;

    @ManyToOne
    @JoinColumn(name = "client_file_id")
    private ClientFile clientFile;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "maternity_nurse_kckz", referencedColumnName = "kckz_number")
    })
    private MaternityNurse maternityNurse;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "midwife_username", referencedColumnName = "username"),
            @JoinColumn(name = "midwife_agb", referencedColumnName = "midwife_agb")
    })
    private Midwife midwife;

    public Long getIndicationId() {
        return indicationId;
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

    public MaternityNurse getMaternityNurse() {
        return maternityNurse;
    }

    public void setMaternityNurse(MaternityNurse maternityNurse) {
        this.maternityNurse = maternityNurse;
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

    public boolean isApproved() {
        return approved;
    }

    public void setIndicationId(Long indicationId) {
        this.indicationId = indicationId;
    }
}