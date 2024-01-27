package com.project.kraamzicht.services;

import com.project.kraamzicht.dtos.ClientFileDto;
import com.project.kraamzicht.dtos.ClientFileReportDto;
import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.models.ClientFileReport;
import com.project.kraamzicht.models.MaternityNurse;
import com.project.kraamzicht.repositories.ClientFileRepository;
import com.project.kraamzicht.repositories.MaternityNurseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.project.kraamzicht.dtos.ClientFileDto.toClientFile;

@Service
@Transactional
public class ClientFileService {


    private final ClientFileRepository clientFileRepository;



    public ClientFileService(ClientFileRepository clientFileRepository) {
        this.clientFileRepository = clientFileRepository;
    }

    public List<ClientFileDto> getAllClientFiles() {
        List<ClientFileDto> collection = new ArrayList<>();
        List<ClientFile> clientFileList = clientFileRepository.findAll();

        for (ClientFile clientFile : clientFileList) {
            collection.add(ClientFileDto.fromClientFile(clientFile));
        }

        return collection;
    }



    public Long createClientFile(ClientFileDto clientFileDto) {
        // Implementeer de logica voor het maken van een ClientFile
        ClientFile newClientFile = toClientFile(clientFileDto);
        clientFileRepository.save(newClientFile);

        return newClientFile.getClientFileId();
    }

    public void addReportToClientFile(Long clientFileId, ClientFileReportDto reportDto) {
        ClientFile existingClientFile = clientFileRepository.findById(clientFileId).orElse(null);

        if (existingClientFile == null) {
            // Handel het scenario af waarin de clientfile niet gevonden wordt
            return;
        }

        ClientFileReport report = ClientFileReportDto.toClientFileReport(reportDto);
        existingClientFile.addReport(report);

        clientFileRepository.save(existingClientFile);
    }

    public void updateClientFile(ClientFile clientFile) {
        clientFileRepository.save(clientFile);
    }

    public ClientFile getClientFileById(Long clientFileId) {
        return clientFileRepository.findById(clientFileId).orElse(null);
    }


}