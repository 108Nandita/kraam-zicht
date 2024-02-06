package com.project.kraamzicht.repositories;

import com.project.kraamzicht.dtos.ClientFileReportDto;
import com.project.kraamzicht.models.ClientFileReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClientFileReportRepository extends JpaRepository<ClientFileReport, Long> {
    @Query("SELECT cfr FROM ClientFileReport cfr WHERE cfr.clientFile.clientFileId = :clientFileId")
    List<ClientFileReportDto> findByClientFileId(@Param("clientFileId") Long clientFileId);
}
