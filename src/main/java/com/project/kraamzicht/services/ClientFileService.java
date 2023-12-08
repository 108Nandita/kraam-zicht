package com.project.kraamzicht.services;

import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.repositories.ClientFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientFileService {

    private final ClientFileRepository clientFileRepository;

    @Autowired
    public ClientFileService(ClientFileRepository clientFileRepository) {
        this.clientFileRepository = clientFileRepository;
    }

    public List<ClientFile> getAllClientFiles() {
        // Logica om alle client files op te halen
        return clientFileRepository.findAll();
    }
}