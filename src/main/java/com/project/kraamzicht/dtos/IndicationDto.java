package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.models.Indication;
import com.project.kraamzicht.models.MaternityNurse;
import com.project.kraamzicht.models.Midwife;
import com.project.kraamzicht.dtos.ClientFileDto;

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
    private UserDto midwife;

    public IndicationDto(Long indicationId, String indicationDescription, int hoursNeeded,
                         boolean approved, LocalDate indicationDate, LocalDate approvalDate,
                         ClientFileDto clientFile, MaternityNurseDto maternityNurse,
                         UserDto midwife) {
        this.indicationId = indicationId;
        this.indicationDescription = indicationDescription;
        this.hoursNeeded = hoursNeeded;
        this.approved = approved;
        this.indicationDate = indicationDate;
        this.approvalDate = approvalDate;
        this.clientFile = clientFile;
        this.maternityNurse = maternityNurse;
        this.midwife = midwife;
    }

    public IndicationDto() {
    }

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

    public UserDto getMaternityNurse() {
        return maternityNurse;
    }

    public void setMaternityNurse(MaternityNurseDto maternityNurse) {
        this.maternityNurse = maternityNurse;
    }

    public UserDto getMidwife() {
        return midwife;
    }

    public void setMidwife(UserDto midwife) {
        this.midwife = midwife;
    }



    public static IndicationDto fromIndication(Indication indication) {
        IndicationDto dto = new IndicationDto();
        dto.setIndicationId(indication.getIndicationId());
        dto.setIndicationDescription(indication.getIndicationDescription());
        dto.setHoursNeeded(indication.getHoursNeeded());
        dto.setApproved(indication.isApproved());
        dto.setIndicationDate(indication.getIndicationDate());
        dto.setApprovalDate(indication.getApprovalDate());

        // Mapping van ClientFile, MaternityNurse en Midwife naar hun respectievelijke DTO's
        dto.setClientFile(ClientFileDto.fromClientFiles(indication.getClientFile()));
        dto.setMaternityNurse(MaternityNurseDto.fromMaternityNurse(indication.getMaternityNurse()));
        dto.setMidwife(UserDto.fromMidwife(indication.getMidwife()));

        return dto;
    }

    public void setIndicationId(Long indicationId) {
        this.indicationId = indicationId;
    }
}