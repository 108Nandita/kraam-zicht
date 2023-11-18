package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.models.MaternityNurse;
import com.project.kraamzicht.models.Midwife;

import java.time.LocalDate;

public class IndicationDto {
    private Long indicationId;
    private String indicationDescription;
    private int hoursNeeded;
    private boolean approved;
    private LocalDate indicationDate;
    private LocalDate approvalDate;
    private ClientFileDto clientFile;
    private MaternityNurseDto maternityNurse;
    private MidwifeDto midwife;

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

    public boolean isApproved() {
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

    public ClientFileDto getClientFile() {
        return clientFile;
    }

    public void setClientFile(ClientFileDto clientFile) {
        this.clientFile = clientFile;
    }

    public MaternityNurseDto getMaternityNurse() {
        return maternityNurse;
    }

    public void setMaternityNurse(MaternityNurseDto maternityNurse) {
        this.maternityNurse = maternityNurse;
    }

    public MidwifeDto getMidwife() {
        return midwife;
    }

    public void setMidwife(MidwifeDto midwife) {
        this.midwife = midwife;
    }
}