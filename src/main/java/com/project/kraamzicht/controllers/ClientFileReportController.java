package com.project.kraamzicht.controllers;

import com.project.kraamzicht.dtos.ClientFileReportDto;
import com.project.kraamzicht.models.ClientFileReport;
import com.project.kraamzicht.services.ClientFileReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client-file-reports")
public class ClientFileReportController {
    private final ClientFileReportService clientFileReportService;

    @Autowired
    public ClientFileReportController(ClientFileReportService clientFileReportService) {
        this.clientFileReportService = clientFileReportService;
    }

    @GetMapping("/{clientFileId}")
    public ResponseEntity<List<ClientFileReportDto>> getClientFileReports(@PathVariable Long clientFileId) {
        List<ClientFileReportDto> clientFileReports = clientFileReportService.getClientFileReports(clientFileId);
        return new ResponseEntity<>(clientFileReports, HttpStatus.OK);
    }
}