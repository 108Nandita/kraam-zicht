package com.project.kraamzicht.integrationTests;

import com.project.kraamzicht.models.Client;
import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.repositories.ClientFileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
@AutoConfigureMockMvc(addFilters = false)
public class ClientFileReportServiceIntegrationTest {

    @Autowired
    private ClientFileRepository clientFileRepository;



    @Test
    public void testSaveClientFile() {

        // Arrange
        ClientFile clientFile = new ClientFile();

        Client client = new Client();

        client.setClientId("12345");

        // act
        clientFileRepository.save(clientFile);

        assertNotNull(clientFile.getClientFileId(), "ClientFile ID mag niet null zijn na opslaan");

        // Assert
        ClientFile retrievedClientFile = clientFileRepository.findById(clientFile.getClientFileId()).orElse(null);
        assertNotNull(retrievedClientFile, "Opgeslagen ClientFile kon niet worden opgehaald");
        assertEquals(clientFile.getClientFileId(), retrievedClientFile.getClientFileId(), "ClientId komt niet overeen");
    }
}