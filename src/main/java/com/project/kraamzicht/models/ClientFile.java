package com.project.kraamzicht.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class ClientFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_file_id", nullable = false, unique = true)

    private long clientFileId;

    @Column
    private LocalDate dueDate;
    @Column
    private LocalDate deliveryDate;
    @Column
    private String deliveryPlace;
    @Column
    private String report;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "admin_username", referencedColumnName = "username"),
            @JoinColumn(name = "admin_personnelNumber", referencedColumnName = "personnelNumber")
    })
    private Admin admin;

    @ManyToOne
    @JoinColumns({

            @JoinColumn(name = "client_id", referencedColumnName = "clientId")
    })
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "clientfile_midwife",
            joinColumns = {
                    @JoinColumn(name = "client_file_id", referencedColumnName = "client_file_id"),
                    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "midwife_agb", referencedColumnName = "midwife_agb")}
    )
    private List<Midwife> midwives;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "maternity_nurse_kckz", referencedColumnName = "kckz_number"),
            @JoinColumn(name = "maternity_nurse_username", referencedColumnName = "username")
    })
    private MaternityNurse maternityNurse;

    @OneToMany
    private List<Indication> indications;

    public ClientFile() {}

    public ClientFile(LocalDate dueDate, LocalDate deliveryDate, String deliveryPlace, String report,
                      Admin admin, Client client, List<Midwife> midwives, MaternityNurse maternityNurse,
                      List<Indication> indications) {
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

    public Admin getAdmin() {
        return admin;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Midwife> getMidwives() {
        return midwives;
    }

    public void setMidwives(List<Midwife> midwives) {
        this.midwives = midwives;
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

