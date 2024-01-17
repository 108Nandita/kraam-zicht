package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.Indication;

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

    public IndicationDto(Long indicationId, String indicationDescription, int hoursNeeded,
                         boolean approved, LocalDate indicationDate, LocalDate approvalDate,
                         ClientFileDto clientFile, MaternityNurseDto maternityNurse,
                         MidwifeDto midwife) {
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



    public static IndicationDto fromIndication(Indication indication) {
        IndicationDto dto = new IndicationDto();
        dto.setIndicationId(indication.getIndicationId());
        dto.setIndicationDescription(indication.getIndicationDescription());
        dto.setHoursNeeded(indication.getHoursNeeded());
        dto.setApproved(indication.isApproved());
        dto.setIndicationDate(indication.getIndicationDate());
        dto.setApprovalDate(indication.getApprovalDate());

//        // Mapping van ClientFile, MaternityNurse en Midwife naar hun respectievelijke DTO's
//        dto.setClientFile(ClientFileDto.fromClientFiles(indication.getClientFile()));
//        dto.setMaternityNurse(UserDto.fromMaternityNurse(indication.getMaternityNurse()));
//        dto.setMidwife(UserDto.fromMidwife(indication.getMidwife()));

        return dto;
    }

    public void setIndicationId(Long indicationId) {
        this.indicationId = indicationId;
    }
}