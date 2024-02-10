package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.Admin;
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

    public static ClientFileReportDto fromClientFileReport(ClientFileReport clientFileReport) {

        ClientFileReportDto dto = new ClientFileReportDto();
        dto.setReportDate(clientFileReport.getReportDate());
        dto.setReport(clientFileReport.getReport());

        return dto;
    }
        public static ClientFileReport toClientFileReport(ClientFileReportDto clientFileReportDto) {
            ClientFileReport clientFileReport = new ClientFileReport();
            clientFileReport.setReportDate(clientFileReportDto.getReportDate());
            clientFileReport.setReport(clientFileReportDto.getReport());
            return clientFileReport;
    }
}