package com.project.kraamzicht.integrationTests;

import com.project.kraamzicht.dtos.ClientFileReportDto;
import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.models.ClientFileReport;
import com.project.kraamzicht.repositories.ClientFileReportRepository;
import com.project.kraamzicht.services.ClientFileReportService;
import com.project.kraamzicht.services.ClientFileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class ClientFileReportServiceIntegrationTest {

    @Autowired
    private ClientFileReportService clientFileReportService;

    @Autowired
    private ClientFileReportRepository clientFileReportRepository;

    @Test
    public void testGetClientFileReports() {
        // Arrange
        ClientFileReport clientFileReport1 = createClientFileReport(LocalDate.now(), "Test report 1");
        ClientFileReport clientFileReport2 = createClientFileReport(LocalDate.now(), "Test report 2");

        clientFileReportRepository.save(clientFileReport1);
        clientFileReportRepository.save(clientFileReport2);

        // Act
        List<ClientFileReportDto> reports = clientFileReportService.getClientFileReports(clientFileReport1.getClientFile().getClientFileId());

        // Assert
        assertNotNull(reports);
        assertEquals(1, reports.size());
        assertEquals(clientFileReport1.getReportDate(), reports.get(0).getReportDate());
        assertEquals(clientFileReport1.getReport(), reports.get(0).getReport());
    }

    private ClientFileReport createClientFileReport(LocalDate reportDate, String report) {
        ClientFile clientFile = new ClientFile();
        // Voeg hier eventueel logica toe voor het maken van een ClientFile

        return new ClientFileReport(reportDate, report, clientFile);
    }
}