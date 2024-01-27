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
    }    public Long getIndicationId() {
        return indicationId;
    }

    public void setIndicationId(Long indicationId) {
        this.indicationId = indicationId;
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

        dto.setClientFile(ClientFileDto.fromClientFile(indication.getClientFile()));
        dto.setMaternityNurse(MaternityNurseDto.fromMaternityNurse(indication.getMaternityNurse()));
        dto.setMidwife(MidwifeDto.fromMidwife(indication.getMidwife()));

        return dto;
    }

    public static Indication toIndication(IndicationDto indicationDto) {
        Indication indication = new Indication();
        indication.setIndicationId(indicationDto.getIndicationId());
        indication.setIndicationDescription(indicationDto.getIndicationDescription());
        indication.setHoursNeeded(indicationDto.getHoursNeeded());
        indication.setApproved(indicationDto.isApproved());
        indication.setIndicationDate(indicationDto.getIndicationDate());
        indication.setApprovalDate(indicationDto.getApprovalDate());

        indication.setClientFile(ClientFileDto.toClientFile(indicationDto.getClientFile()));
        indication.setMaternityNurse(MaternityNurseDto.toMaternityNurse(indicationDto.getMaternityNurse()));
        indication.setMidwife(MidwifeDto.toMidwife(indicationDto.getMidwife()));

        return indication;
    }


}