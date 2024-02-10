package com.project.kraamzicht.integrationTests;

import com.project.kraamzicht.models.Client;
import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.repositories.ClientFileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
public class ClientFileIntegrationTest {

    @Autowired
    private ClientFileRepository clientFileRepository;

    @Test
    public void testSaveClientFile() {


        // Arrange
        ClientFile clientFile = new ClientFile();

        Client client = new Client();
        client.setClientId("12345");

        // Act
        clientFileRepository.save(clientFile);

        // Assert
        assertNotNull(clientFile.getClientFileId(), "ClientFile ID should not be null after saving");

        ClientFile retrievedClientFile = clientFileRepository.findById(clientFile.getClientFileId()).orElse(null);
        assertNotNull(retrievedClientFile, "Saved ClientFile could not be retrieved");
        assertEquals(clientFile.getClientFileId(), retrievedClientFile.getClientFileId(), "ClientFile IDs do not match");

    }
}