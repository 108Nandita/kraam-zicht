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
    private AdminDto admin;
    private ClientDto client;
    private List<UserEntityDto> midwives;
    private MaternityNurseDto maternityNurse;
    private List<IndicationDto> indications;

    public ClientFileDto() {
    }

    public ClientFileDto(long clientFileId, LocalDate dueDate, LocalDate deliveryDate, String deliveryPlace,
                         String report, AdminDto admin, ClientDto client, List<UserEntityDto> midwives,
                         MaternityNurseDto maternityNurse, List<IndicationDto> indications) {
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

    public AdminDto getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDto admin) {
        this.admin = admin;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public List<UserEntityDto> getMidwives() {
        return midwives;
    }

    public void setMidwives(List<UserEntityDto> midwives) {
        this.midwives = midwives;
    }

    public UserDto getMaternityNurse() {
        return maternityNurse;
    }

    public void setMaternityNurse(MaternityNurseDto maternityNurse) {
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

//        // Mapping van Admin, Client en MaternityNurse naar UserDto
//        dto.setAdmin(UserDto.fromAdmin(clientFile.getAdmin()));
//        dto.setClient(UserDto.fromClient(clientFile.getClient()));
//        dto.setMidwives(clientFile.getMidwives().stream().map(UserDto::fromMidwife).collect(Collectors.toList()));
//        dto.setMaternityNurse(UserDto.fromMaternityNurse(clientFile.getMaternityNurse()));

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

