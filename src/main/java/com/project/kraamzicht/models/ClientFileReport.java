package com.project.kraamzicht.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ClientFileReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_file_id")
    private ClientFile clientFile;

    private LocalDate reportDate;
    private String report;

    public ClientFileReport() {
    }

    public ClientFileReport(LocalDate reportDate, String report, ClientFile clientFile) {
        this.reportDate = reportDate;
        this.report = report;
        this.clientFile = clientFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientFile getClientFile() {
        return clientFile;
    }

    public void setClientFile(ClientFile clientFile) {
        this.clientFile = clientFile;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}