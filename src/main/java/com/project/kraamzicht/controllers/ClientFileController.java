package com.project.kraamzicht.controllers;

import com.project.kraamzicht.dtos.ClientFileDto;
import com.project.kraamzicht.dtos.ClientFileReportDto;
import com.project.kraamzicht.dtos.MaternityNurseDto;
import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.models.ClientFileReport;
import com.project.kraamzicht.models.MaternityNurse;
import com.project.kraamzicht.services.ClientFileService;
import com.project.kraamzicht.services.MaternityNurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client-files")
public class ClientFileController {

    @Autowired
    private MaternityNurseService maternityNurseService;
    private final ClientFileService clientFileService;


    @Autowired
    public ClientFileController(ClientFileService clientFileService) {
        this.clientFileService = clientFileService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ClientFileDto>> getAllClientFiles() {
        List<ClientFileDto> clientFiles = clientFileService.getAllClientFiles();
        return ResponseEntity.ok(clientFiles);
    }

    @PostMapping("/createClientFile")
    public ResponseEntity<Long> createClientFile(@RequestBody ClientFileDto dto) {

        Long newClientFileId = clientFileService.createClientFile(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{clientFileId}")
                .buildAndExpand(newClientFileId).toUri();

        return ResponseEntity.created(location).body(newClientFileId);
    }

    @PostMapping("/{clientFileId}/addReport")
    public ResponseEntity<Void> addReportToClientFile(@PathVariable Long clientFileId, @RequestBody ClientFileReportDto reportDto) {
        ClientFile existingClientFile = clientFileService.getClientFileById(clientFileId);

        if (existingClientFile == null) {
            return ResponseEntity.notFound().build();
        }

        ClientFileReport report = ClientFileReportDto.toClientFileReport(reportDto);
        existingClientFile.addReport(report);

        clientFileService.updateClientFile(existingClientFile);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{clientFileId}/updateData")
    public ResponseEntity<Void> updateClientFileData(@PathVariable Long clientFileId, @RequestBody ClientFileDto updatedData) {
        clientFileService.updateClientFileData(clientFileId, updatedData);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{clientFileId}/updateMaternityNurse")
    public ResponseEntity<Void> updateMaternityNurse(@PathVariable Long clientFileId, @RequestBody MaternityNurseDto updatedMaternityNurseData) {
        clientFileService.updateMaternityNurse(clientFileId, updatedMaternityNurseData);
        return ResponseEntity.ok().build();
    }

}

