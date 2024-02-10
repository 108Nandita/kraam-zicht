package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientFileDto {

    private long clientFileId;
    private LocalDate dueDate;
    private LocalDate deliveryDate;
    private String deliveryPlace;

    private List<Long> reportId;
    private String clientId;
    private long kckzNumber;
    private List<Long> indicationId;

    public ClientFileDto(long clientFileId, LocalDate dueDate, LocalDate deliveryDate, String deliveryPlace, List<Long> reportId, String clientId, long kckzNumber, List<Long> indicationId) {
        this.clientFileId = clientFileId;
        this.dueDate = dueDate;
        this.deliveryDate = deliveryDate;
        this.deliveryPlace = deliveryPlace;
        this.reportId = reportId;
        this.clientId = clientId;
        this.kckzNumber = kckzNumber;
        this.indicationId = indicationId;
    }

    public ClientFileDto() {
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

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


    public long getKckzNumber() {
        return kckzNumber;
    }

    public void setKckzNumber(long kckzNumber) {
        this.kckzNumber = kckzNumber;
    }

    public List<Long> getReports() {
        return reportId;
    }

    public void setReportId(List<Long> reportId) {
        this.reportId = reportId;
    }

    public void setIndicationId(List<Long> indicationId) {
        this.indicationId = indicationId;
    }

    public List<Long> getIndicationId() {
        return indicationId;
    }

    public static ClientFileDto fromClientFile(ClientFile clientFile) {
        ClientFileDto dto = new ClientFileDto();
        dto.setClientFileId(clientFile.getClientFileId());
        dto.setDueDate(clientFile.getDueDate());
        dto.setDeliveryDate(clientFile.getDeliveryDate());
        dto.setDeliveryPlace(clientFile.getDeliveryPlace());
        dto.setReportId(clientFile.getReports().stream().map(ClientFileReport::getReportId).collect(Collectors.toList()));
        dto.setClientId(clientFile.getClient().getClientId());
        dto.setKckzNumber(clientFile.getMaternityNurse().getKckzNumber());
        dto.setIndicationId(clientFile.getIndications().stream().map(Indication::getIndicationId).collect(Collectors.toList()));

        return dto;
    }

    public static ClientFile toClientFile(ClientFileDto clientFileDto, MaternityNurse maternityNurse, Client client) {
        ClientFile clientFile = new ClientFile();
        clientFile.setClientFileId(clientFileDto.getClientFileId());
        clientFile.setDueDate(clientFileDto.getDueDate());
        clientFile.setDeliveryDate(clientFileDto.getDeliveryDate());
        clientFile.setDeliveryPlace(clientFileDto.getDeliveryPlace());
        clientFile.setMaternityNurse(maternityNurse);
        clientFile.setClient(client);

        return clientFile;
    }

    public static ClientFile toClientFile(ClientFileDto clientFileDto) {
        ClientFile clientFile = new ClientFile();
        clientFile.setClientFileId(clientFileDto.getClientFileId());
        clientFile.setDueDate(clientFileDto.getDueDate());
        clientFile.setDeliveryDate(clientFileDto.getDeliveryDate());
        clientFile.setDeliveryPlace(clientFileDto.getDeliveryPlace());

        return clientFile;
    }

}