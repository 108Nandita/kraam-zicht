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

        MaternityNurseDto maternityNurseDto = (MaternityNurseDto) dto.getMaternityNurse();
        if (maternityNurseDto != null && maternityNurseDto.getKckzNumber() != 0) {
            long kckzNumber = maternityNurseDto.getKckzNumber();
            MaternityNurse maternityNurse = maternityNurseService.findMaternityNurseByKckzNumber(kckzNumber);

            dto.setMaternityNurse(MaternityNurseDto.fromMaternityNurse(maternityNurse));
        }

        Long newClientFileId = clientFileService.createClientFile(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{clientFileId}")
                .buildAndExpand(newClientFileId).toUri();
        
        return ResponseEntity.created(location).body(newClientFileId);
    }

    @PostMapping("/{clientFileId}/addReport")
    public ResponseEntity<Void> addReportToClientFile(@PathVariable Long clientFileId, @RequestBody ClientFileReportDto reportDto) {
        // Haal het bestaande zwangerschapsdossier op
        ClientFile existingClientFile = clientFileService.getClientFileById(clientFileId);

        if (existingClientFile == null) {
            return ResponseEntity.notFound().build();
        }

        // Voeg het rapport toe aan het zwangerschapsdossier
        ClientFileReport report = ClientFileReportDto.toClientFileReport(reportDto);
        existingClientFile.addReport(report);

        // Sla het zwangerschapsdossier op om de wijzigingen door te voeren
        clientFileService.updateClientFile(existingClientFile);

        return ResponseEntity.ok().build();
    }


}