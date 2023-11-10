package com.project.kraamzicht.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class ClientFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String fileNumber;

    private LocalDate dueDate;
    private LocalDate deliveryDate;
    private String deliveryPlace;
    private String report;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "midwife_agb")
    private Midwife midwife;

    @ManyToOne
    @JoinColumn(name = "maternity_nurse_kzkz")
    private MaternityNurse maternityNurse;

    @OneToMany(mappedBy = "clientFile")
    private List<Indication> indications;

    public ClientFile() {}

    public ClientFile(Client client, Midwife midwife, MaternityNurse maternityNurse, List<Indication> indications) {
        this.client = client;
        this.midwife = midwife;
        this.maternityNurse = maternityNurse;
        this.indications = indications;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Midwife getMidwife() {
        return midwife;
    }

    public void setMidwife(Midwife midwife) {
        this.midwife = midwife;
    }

    public MaternityNurse getMaternityNurse() {
        return maternityNurse;
    }

    public void setMaternityNurse(MaternityNurse maternityNurse) {
        this.maternityNurse = maternityNurse;
    }

    public List<Indication> getIndications() {
        return indications;
    }

    public void setIndications(List<Indication> indications) {
        this.indications = indications;
    }
}