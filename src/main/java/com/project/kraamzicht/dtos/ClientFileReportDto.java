package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.ClientFileReport;

import java.time.LocalDate;

public class ClientFileReportDto {

    private LocalDate reportDate;
    private String report;

    public ClientFileReportDto() {
    }

    public ClientFileReportDto(LocalDate reportDate, String report) {
        this.reportDate = reportDate;
        this.report = report;
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

    public static ClientFileReportDto fromClientFileReport(ClientFileReport report) {
        return new ClientFileReportDto(report.getReportDate(), report.getReport());
    }

    public static ClientFileReport toClientFileReport(ClientFileReportDto reportDto) {
        return new ClientFileReport(reportDto.getReportDate(), reportDto.getReport(), null);
    }
}