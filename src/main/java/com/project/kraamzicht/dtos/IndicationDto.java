package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.Indication;
import com.project.kraamzicht.models.MaternityNurse;

import java.time.LocalDate;

public class IndicationDto {
    private Long indicationId;
    private String indicationDescription;
    private int hoursNeeded;
    private boolean approved;
    private LocalDate indicationDate;
    private LocalDate approvalDate;
    private Long maternityNurseKckzNumber; // KCKZ number instead of MaternityNurseDto

    public IndicationDto() {
    }

    public IndicationDto(Long indicationId, String indicationDescription, int hoursNeeded,
                         boolean approved, LocalDate indicationDate, LocalDate approvalDate,
                         Long maternityNurseKckzNumber) {
        this.indicationId = indicationId;
        this.indicationDescription = indicationDescription;
        this.hoursNeeded = hoursNeeded;
        this.approved = approved;
        this.indicationDate = indicationDate;
        this.approvalDate = approvalDate;
        this.maternityNurseKckzNumber = maternityNurseKckzNumber;
    }

    // Getters and setters...

    public static IndicationDto fromIndication(Indication indication) {
        IndicationDto dto = new IndicationDto();
        dto.setIndicationId(indication.getIndicationId());
        dto.setIndicationDescription(indication.getIndicationDescription());
        dto.setHoursNeeded(indication.getHoursNeeded());
        dto.setApproved(indication.isApproved());
        dto.setIndicationDate(indication.getIndicationDate());
        dto.setApprovalDate(indication.getApprovalDate());

        // Set maternity nurse KCKZ number instead of MaternityNurseDto
        if (indication.getMaternityNurse() != null) {
            dto.setMaternityNurseKckzNumber(indication.getMaternityNurse().getKckzNumber());
        }

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

        // Create a new MaternityNurse and set its KCKZ number
        MaternityNurse maternityNurse = new MaternityNurse();
        maternityNurse.setKckzNumber(indicationDto.getMaternityNurseKckzNumber());
        indication.setMaternityNurse(maternityNurse);

        return indication;
    }

    public String getIndicationDescription() {
        return indicationDescription;
    }

    public void setIndicationDescription(String indicationDescription) {
        this.indicationDescription = indicationDescription;
    }

    public Long getIndicationId() {
        return indicationId;
    }

    public void setIndicationId(Long indicationId) {
        this.indicationId = indicationId;
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

    public Long getMaternityNurseKckzNumber() {
        return maternityNurseKckzNumber;
    }

    public void setMaternityNurseKckzNumber(Long maternityNurseKckzNumber) {
        this.maternityNurseKckzNumber = maternityNurseKckzNumber;
    }
}