package com.project.kraamzicht.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ClientFileReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "report-client_file_id")
    private ClientFile clientFile;

    private LocalDate reportDate;
    private String report;

    public ClientFileReport() {
    }
    public ClientFileReport(LocalDate reportDate, String report, ClientFile clientFile) {
        this.reportId = reportId;
        this.reportDate = reportDate;
        this.report = report;
        this.clientFile = clientFile;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setId(Long reportIdReportId) {
        this.reportId = reportId;
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