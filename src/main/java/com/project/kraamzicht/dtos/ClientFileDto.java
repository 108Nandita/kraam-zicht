package com.project.kraamzicht.dtos;


import com.project.kraamzicht.models.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ClientFileDto {
    private long clientFileId;
    private LocalDate dueDate;
    private LocalDate deliveryDate;
    private String deliveryPlace;
    private String report;
    private UserDto admin;
    private UserDto client;
    private List<UserDto> midwives;
    private UserDto maternityNurse;
    private List<IndicationDto> indications;

    public ClientFileDto() {
    }

    public ClientFileDto(long clientFileId, LocalDate dueDate, LocalDate deliveryDate, String deliveryPlace,
                         String report, UserDto admin, UserDto client, List<UserDto> midwives,
                         UserDto maternityNurse, List<IndicationDto> indications) {
        this.clientFileId = clientFileId;
        this.dueDate = dueDate;
        this.deliveryDate = deliveryDate;
        this.deliveryPlace = deliveryPlace;
        this.report = report;
        this.admin = admin;
        this.client = client;
        this.midwives = midwives;
        this.maternityNurse = maternityNurse;
        this.indications = indications;
    }

    public long getClientFileId() {
        return clientFileId;
    }

    public void setClientFileId(long clientFileId) {
        this.clientFileId = clientFileId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public UserDto getAdmin() {
        return admin;
    }

    public void setAdmin(UserDto admin) {
        this.admin = admin;
    }

    public UserDto getClient() {
        return client;
    }

    public void setClient(UserDto client) {
        this.client = client;
    }

    public List<UserDto> getMidwives() {
        return midwives;
    }

    public void setMidwives(List<UserDto> midwives) {
        this.midwives = midwives;
    }

    public UserDto getMaternityNurse() {
        return maternityNurse;
    }

    public void setMaternityNurse(UserDto maternityNurse) {
        this.maternityNurse = maternityNurse;
    }

    public List<IndicationDto> getIndications() {
        return indications;
    }

    public void setIndications(List<IndicationDto> indications) {
        this.indications = indications;
    }

    public static ClientFileDto fromClientFiles(ClientFile clientFile) {
        ClientFileDto dto = new ClientFileDto();
        dto.setClientFileId(clientFile.getClientFileId());
        dto.setDueDate(clientFile.getDueDate());
        dto.setDeliveryDate(clientFile.getDeliveryDate());
        dto.setDeliveryPlace(clientFile.getDeliveryPlace());
        dto.setReport(clientFile.getReport());

        // Mapping van Admin, Client en MaternityNurse naar UserDto
        dto.setAdmin(UserDto.fromAdmin(clientFile.getAdmin()));
        dto.setClient(UserDto.fromClient(clientFile.getClient()));
        dto.setMidwives(clientFile.getMidwives().stream().map(UserDto::fromMidwife).collect(Collectors.toList()));
        dto.setMaternityNurse(UserDto.fromMaternityNurse(clientFile.getMaternityNurse()));

        // Mapping van Indication naar IndicationDto
        dto.setIndications(clientFile.getIndications().stream().map(IndicationDto::fromIndication).collect(Collectors.toList()));

        return dto;
    }

    public static List<ClientFileDto> convertListFromClientFiles(List<ClientFile> clientFiles) {
        return clientFiles.stream()
                .map(ClientFileDto::fromClientFiles)
                .collect(Collectors.toList());
    }
}

