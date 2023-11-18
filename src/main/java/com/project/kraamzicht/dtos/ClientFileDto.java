package com.project.kraamzicht.dtos;


import com.project.kraamzicht.models.Admin;
import com.project.kraamzicht.models.Client;
import com.project.kraamzicht.models.MaternityNurse;
import com.project.kraamzicht.models.Midwife;

import java.time.LocalDate;
import java.util.List;

public class ClientFileDto {
    private long clientFileId;
    private LocalDate dueDate;
    private LocalDate deliveryDate;
    private String deliveryPlace;
    private String report;
    private AdminDto admin;
    private ClientDto client;
    private List<MidwifeDto> midwives;
    private MaternityNurseDto maternityNurse;
    private List<IndicationDto> indications;

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

    public List<MidwifeDto> getMidwives() {
        return midwives;
    }

    public void setMidwives(List<MidwifeDto> midwives) {
        this.midwives = midwives;
    }

    public MaternityNurseDto getMaternityNurse() {
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
}