package com.project.kraamzicht.services;

import com.project.kraamzicht.dtos.ClientFileDto;
import com.project.kraamzicht.dtos.ClientFileReportDto;
import com.project.kraamzicht.dtos.MaternityNurseDto;
import com.project.kraamzicht.models.Client;
import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.models.ClientFileReport;
import com.project.kraamzicht.models.MaternityNurse;
import com.project.kraamzicht.repositories.ClientFileReportRepository;
import com.project.kraamzicht.repositories.ClientFileRepository;
import com.project.kraamzicht.repositories.ClientRepository;
import com.project.kraamzicht.repositories.MaternityNurseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.project.kraamzicht.dtos.ClientFileDto.toClientFile;

@Service
@Transactional
public class ClientFileService {


    private final ClientFileRepository clientFileRepository;
    private final MaternityNurseService maternityNurseService;
    private final MaternityNurseRepository maternityNurseRepository;
    private final ClientRepository clientRepository;
    private final ClientFileReportRepository clientFileReportRepository;


    public ClientFileService(ClientFileRepository clientFileRepository, MaternityNurseService maternityNurseService, MaternityNurseRepository maternityNurseRepository, ClientRepository clientRepository, ClientFileReportRepository clientFileReportRepository) {
        this.clientFileRepository = clientFileRepository;
        this.maternityNurseService = maternityNurseService;
        this.maternityNurseRepository = maternityNurseRepository;
        this.clientRepository = clientRepository;
        this.clientFileReportRepository = clientFileReportRepository;
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


        if (clientFileDto != null && clientFileDto.getKckzNumber() != 0) {
            long kckzNumber = clientFileDto.getKckzNumber();
            MaternityNurse maternityNurse = maternityNurseService.findMaternityNurseByKckzNumber(kckzNumber);

            Client client = clientRepository.findByClientId(clientFileDto.getClientId());
        // Implementeer de logica voor het maken van een ClientFile
        ClientFile newClientFile = toClientFile(clientFileDto,maternityNurse,client);
        clientFileRepository.save(newClientFile);

        return newClientFile.getClientFileId();
    }
        return null;
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

    public void updateClientFileData(Long clientFileId, ClientFileDto updatedData) {
        ClientFile existingClientFile = clientFileRepository.findById(clientFileId).orElse(null);

        if (existingClientFile != null && updatedData != null) {
            existingClientFile.setDueDate(updatedData.getDueDate());
            existingClientFile.setDeliveryDate(updatedData.getDeliveryDate());
            existingClientFile.setDeliveryPlace(updatedData.getDeliveryPlace());

            clientFileRepository.save(existingClientFile);
        }
    }

    public void updateMaternityNurse(Long clientFileId, MaternityNurseDto updatedMaternityNurseData) {
        ClientFile existingClientFile = clientFileRepository.findById(clientFileId).orElse(null);

        if (existingClientFile != null && updatedMaternityNurseData != null) {
            MaternityNurse existingMaternityNurse = existingClientFile.getMaternityNurse();
            MaternityNurse newMaternityNurse = maternityNurseRepository.findByKckzNumber(updatedMaternityNurseData.getKckzNumber());

            if (newMaternityNurse != null && !newMaternityNurse.equals(existingMaternityNurse)) {
                existingClientFile.setMaternityNurse(newMaternityNurse);
                clientFileRepository.save(existingClientFile);
            } else {
                existingMaternityNurse.setKckzNumber(updatedMaternityNurseData.getKckzNumber());

                maternityNurseService.updateMaternityNurseKckzNumber(existingMaternityNurse);

                existingClientFile.setMaternityNurse(existingMaternityNurse);

                clientFileRepository.save(existingClientFile);
            }
        }
    }}




