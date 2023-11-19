package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.Indication;
import com.project.kraamzicht.models.Midwife;

import java.util.List;

public class MidwifeDto extends UserDto {
    private long agbCode;
    private String certification;
    private List<Indication> approvedIndications;

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

    public static MidwifeDto fromMidwife(Midwife midwife) {
        MidwifeDto dto = new MidwifeDto();
        // Mapping from Midwife to MidwifeDto
        dto.setAgbCode(midwife.getAgbCode());
        dto.setCertification(midwife.getCertification());
        dto.setApprovedIndications(midwife.getApprovedIndications());
        // Set common properties from User class
        dto.setUsername(midwife.getUsername());
        dto.setPassword(midwife.getPassword());
        dto.setEnabled(midwife.isEnabled());
        dto.setApikey(midwife.getApikey());
        dto.setEmail(midwife.getEmail());
        dto.setAuthorities(midwife.getAuthorities());
        dto.setName(midwife.getName());
        dto.setSurname(midwife.getSurname());
        dto.setDob(midwife.getDob());
        dto.setAddress(midwife.getAddress());
        dto.setPostalcode(midwife.getPostalcode());
        dto.setPlace(midwife.getPlace());
        dto.setPhoneNr(midwife.getPhoneNr());
        dto.setRole(midwife.getRole());

        return dto;
    }
}
