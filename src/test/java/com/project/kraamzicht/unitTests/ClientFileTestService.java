package com.project.kraamzicht.unitTests;

import com.project.kraamzicht.dtos.ClientFileDto;
import com.project.kraamzicht.dtos.ClientFileReportDto;
import com.project.kraamzicht.dtos.MaternityNurseDto;
import com.project.kraamzicht.models.Client;
import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.models.MaternityNurse;
import com.project.kraamzicht.repositories.ClientFileRepository;
import com.project.kraamzicht.repositories.ClientRepository;
import com.project.kraamzicht.repositories.MaternityNurseRepository;
import com.project.kraamzicht.services.ClientFileService;
import com.project.kraamzicht.services.MaternityNurseService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClientFileTestService {

    @Mock
    private ClientFileRepository clientFileRepository;

    @Mock
    private MaternityNurseService maternityNurseService;

    @Mock
    private MaternityNurseRepository maternityNurseRepository;

    @Mock
    private ClientRepository clientRepository;


    @InjectMocks
    private ClientFileService clientFileService;

    @Test
    void createClientFile() {
        // Arrange
        ClientFileDto clientFileDto = new ClientFileDto();
        clientFileDto.setKckzNumber(123);

        when(maternityNurseService.findMaternityNurseByKckzNumber(123)).thenReturn(new MaternityNurse());

        when(clientRepository.findByClientId(String.valueOf(anyLong()))).thenReturn(new Client());

        when(clientFileRepository.save(any(ClientFile.class))).thenReturn(new ClientFile());

        // Act
        Long result = clientFileService.createClientFile(clientFileDto);

        // Assert
        assertNotNull(result);
    }

    @Test
    void addReportToClientFile() {
        // Arrange
        Long clientFileId = 1L;
        ClientFileReportDto reportDto = new ClientFileReportDto();

        ClientFile existingClientFile = new ClientFile();
        existingClientFile.setClientFileId(clientFileId);

        // Mock behavior of clientFileRepository
        when(clientFileRepository.findById(clientFileId)).thenReturn(Optional.of(existingClientFile));

        // Act
        clientFileService.addReportToClientFile(clientFileId, reportDto);

        // Assert
        // Add assertions based on the behavior you want to test
    }
    @Test
    void getAllClientFiles_ShouldReturnEmptyListWhenNoClientFilesExist() {
        // Arrange
        when(clientFileRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<ClientFileDto> result = clientFileService.getAllClientFiles();

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    void createClientFile_ShouldReturnClientFileIdWhenSuccessful() {
        // Arrange
        ClientFileDto clientFileDto = new ClientFileDto();
        clientFileDto.setKckzNumber(123);
        clientFileDto.setClientId(String.valueOf(456));

        MaternityNurse maternityNurse = new MaternityNurse();
        Client client = new Client();

        when(maternityNurseService.findMaternityNurseByKckzNumber(anyLong())).thenReturn(maternityNurse);
        when(clientRepository.findByClientId(String.valueOf(anyLong()))).thenReturn(client);
        when(clientFileRepository.save(any(ClientFile.class))).thenReturn(new ClientFile());

        // Act
        Long result = clientFileService.createClientFile(clientFileDto);

        // Assert
        assertNotNull(result);
    }

    @Test
    void createClientFile_ShouldReturnNullWhenKckzNumberIsZero() {
        // Arrange
        ClientFileDto clientFileDto = new ClientFileDto();
        clientFileDto.setKckzNumber(0);

        // Act
        Long result = clientFileService.createClientFile(clientFileDto);

        // Assert
        assertNull(result);
    }

    @Test
    void updateClientFile_ShouldUpdateClientFileInRepository() {
        // Arrange
        ClientFile clientFile = new ClientFile();

        // Stub the clientFileRepository
        when(clientFileRepository.save(any(ClientFile.class))).thenReturn(clientFile);

        // Act
        clientFileService.updateClientFile(clientFile);

        // Assert
        Mockito.verify(clientFileRepository).save(clientFile);
    }

    @Test
    void getClientFileById_ShouldReturnClientFileWhenIdExists() {
        // Arrange
        Long clientFileId = 1L;
        ClientFile expectedClientFile = new ClientFile();

        when(clientFileRepository.findById(anyLong())).thenReturn(java.util.Optional.of(expectedClientFile));

        // Act
        ClientFile result = clientFileService.getClientFileById(clientFileId);

        // Assert
        assertNotNull(result);
        assertEquals(expectedClientFile, result);
    }

    @Test
    void getClientFileById_ShouldReturnNullWhenIdDoesNotExist() {
        // Arrange
        Long clientFileId = 1L;

        when(clientFileRepository.findById(anyLong())).thenReturn(java.util.Optional.empty());

        // Act
        ClientFile result = clientFileService.getClientFileById(clientFileId);

        // Assert
        assertNull(result);
    }

    @Test
    void updateClientFileData_ShouldUpdateClientFileDataWhenClientFileExistsAndUpdatedDataNotNull() {
        // Arrange
        Long clientFileId = 1L;
        ClientFile existingClientFile = new ClientFile();
        ClientFileDto updatedData = new ClientFileDto();
        updatedData.setDueDate(LocalDate.now());

        when(clientFileRepository.findById(anyLong())).thenReturn(java.util.Optional.of(existingClientFile));

        // Act
        clientFileService.updateClientFileData(clientFileId, updatedData);

        // Assert
        assertEquals(updatedData.getDueDate(), existingClientFile.getDueDate());
    }

    @Test
    void updateMaternityNurse_ShouldUpdateMaternityNurseWhenClientFileExistsAndUpdatedMaternityNurseDataNotNull() {
        // Arrange
        Long clientFileId = 1L;
        ClientFile existingClientFile = new ClientFile();
        MaternityNurseDto updatedMaternityNurseData = new MaternityNurseDto();
        updatedMaternityNurseData.setKckzNumber(123);

        MaternityNurse existingMaternityNurse = new MaternityNurse();
        when(clientFileRepository.findById(anyLong())).thenReturn(java.util.Optional.of(existingClientFile));
        when(maternityNurseRepository.findByKckzNumber(anyLong())).thenReturn(existingMaternityNurse);

        // Act
        clientFileService.updateMaternityNurse(clientFileId, updatedMaternityNurseData);

        // Assert
        assertEquals(existingMaternityNurse, existingClientFile.getMaternityNurse());
    }

}

