package com.project.kraamzicht.controllers;

import com.project.kraamzicht.dtos.ClientFileDto;
import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.services.ClientFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client-files")
public class ClientFileController {

    private final ClientFileService clientFileService;

    @Autowired
    public ClientFileController(ClientFileService clientFileService) {
        this.clientFileService = clientFileService;
    }

    @GetMapping
    public ResponseEntity<List<ClientFileDto>> getAllClientFiles() {
        List<ClientFile> clientFiles = clientFileService.getAllClientFiles();
        List<ClientFileDto> clientFileDtos = clientFiles.stream()
                .map(ClientFileDto::fromClientFiles)
                .collect(Collectors.toList());
        return new ResponseEntity<>(clientFileDtos, HttpStatus.OK);
    }
}