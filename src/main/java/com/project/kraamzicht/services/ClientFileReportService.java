package com.project.kraamzicht.services;

import com.project.kraamzicht.dtos.ClientFileReportDto;
import com.project.kraamzicht.repositories.ClientFileReportRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClientFileReportService {
    private final ClientFileReportRepository clientFileReportRepository;

    @Autowired
    public ClientFileReportService(ClientFileReportRepository clientFileReportRepository) {
        this.clientFileReportRepository = clientFileReportRepository;
    }

    public List<ClientFileReportDto> getClientFileReports(Long clientFileId) {
        return clientFileReportRepository.findByClientFileId(clientFileId);
    }
}
