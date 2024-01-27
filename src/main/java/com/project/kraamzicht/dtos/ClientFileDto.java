package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.Client;
import com.project.kraamzicht.models.ClientFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientFileDto {

    private long clientFileId;
    private LocalDate dueDate;
    private LocalDate deliveryDate;
    private String deliveryPlace;
    private List<ClientFileReportDto> reports;
    private String clientId;
    private List<MidwifeDto> midwives;
    private MaternityNurseDto maternityNurse;
    private List<IndicationDto> indications;

    // Lege constructor
    public ClientFileDto() {
    }

    // Constructor met alle velden
    public ClientFileDto(long clientFileId, LocalDate dueDate, LocalDate deliveryDate, String deliveryPlace,
                         List<ClientFileReportDto> reports, String clientId, List<MidwifeDto> midwives,
                         MaternityNurseDto maternityNurse, List<IndicationDto> indications) {
        this.clientFileId = clientFileId;
        this.dueDate = dueDate;
        this.deliveryDate = deliveryDate;
        this.deliveryPlace = deliveryPlace;
        this.reports = reports;
        this.clientId = clientId;
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

    public List<ClientFileReportDto> getReports() {
        return reports == null ? new ArrayList<>() : reports;
    }

    public void setReports(List<ClientFileReportDto> reports) {
        this.reports = reports;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public List<MidwifeDto> getMidwives() {
        return midwives == null ? new ArrayList<>() : midwives;
    }

    public void setMidwives(List<MidwifeDto> midwives) {
        this.midwives = midwives;
    }

    public MaternityNurseDto getMaternityNurse() {
        return maternityNurse == null ? new MaternityNurseDto() : maternityNurse;
    }

    public void setMaternityNurse(MaternityNurseDto maternityNurse) {
        this.maternityNurse = maternityNurse;
    }

    public List<IndicationDto> getIndications() {
        return indications == null ? new ArrayList<>() : indications;
    }

    public void setIndications(List<IndicationDto> indications) {
        this.indications = indications;
    }

    public static ClientFileDto fromClientFile(ClientFile clientFile) {
        ClientFileDto dto = new ClientFileDto();
        dto.setClientFileId(clientFile.getClientFileId());
        dto.setDueDate(clientFile.getDueDate());
        dto.setDeliveryDate(clientFile.getDeliveryDate());
        dto.setDeliveryPlace(clientFile.getDeliveryPlace());
        dto.setReports(clientFile.getReports().stream().map(ClientFileReportDto::fromClientFileReport).collect(Collectors.toList()));
        dto.setClientId(clientFile.getClient().getClientId());
        dto.setMaternityNurse(MaternityNurseDto.fromMaternityNurse(clientFile.getMaternityNurse()));
        dto.setMidwives(clientFile.getMidwives().stream().map(MidwifeDto::fromMidwife).collect(Collectors.toList()));
        dto.setIndications(clientFile.getIndications().stream().map(IndicationDto::fromIndication).collect(Collectors.toList()));

        return dto;
    }

    public static ClientFile toClientFile(ClientFileDto clientFileDto) {
        ClientFile clientFile = new ClientFile();
        clientFile.setClientFileId(clientFileDto.getClientFileId());
        clientFile.setDueDate(clientFileDto.getDueDate());
        clientFile.setDeliveryDate(clientFileDto.getDeliveryDate());
        clientFile.setDeliveryPlace(clientFileDto.getDeliveryPlace());
        clientFile.setReports(clientFileDto.getReports().stream().map(ClientFileReportDto::toClientFileReport).collect(Collectors.toList()));
        Client client = new Client();
        client.setClientId(clientFileDto.getClientId());
        clientFile.setClient(client);
        clientFile.setMaternityNurse(MaternityNurseDto.toMaternityNurse((MaternityNurseDto) clientFileDto.getMaternityNurse()));
        clientFile.setMidwives(clientFileDto.getMidwives().stream().map(MidwifeDto::toMidwife).collect(Collectors.toList()));
        clientFile.setIndications(clientFileDto.getIndications().stream().map(IndicationDto::toIndication).collect(Collectors.toList()));

        return clientFile;
    }
}