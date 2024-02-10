package com.project.kraamzicht.services;

import com.project.kraamzicht.dtos.IndicationDto;
import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.models.Indication;
import com.project.kraamzicht.models.MaternityNurse;
import com.project.kraamzicht.repositories.IndicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IndicationService {
    private final IndicationRepository indicationRepository;
    private final ClientFileService clientFileService;
    private final MaternityNurseService maternityNurseService;

    @Autowired
    public IndicationService(IndicationRepository indicationRepository,
                             ClientFileService clientFileService,
                             MaternityNurseService maternityNurseService) {
        this.indicationRepository = indicationRepository;
        this.clientFileService = clientFileService;
        this.maternityNurseService = maternityNurseService;
    }

    public Long createIndication(IndicationDto indicationDto, Long clientFileId, Long maternityNurseKckzNumber) {
        ClientFile clientFile = clientFileService.getClientFileById(clientFileId);
        MaternityNurse maternityNurse = maternityNurseService.findMaternityNurseByKckzNumber(maternityNurseKckzNumber);

        if (clientFile != null && maternityNurse != null) {
            Indication indication = new Indication();
            indication.setIndicationDescription(indicationDto.getIndicationDescription());
            indication.setHoursNeeded(indicationDto.getHoursNeeded());
            indication.setApproved(indicationDto.isApproved());
            indication.setIndicationDate(indicationDto.getIndicationDate());
            indication.setApprovalDate(indicationDto.getApprovalDate());
            indication.setClientFile(clientFile);
            indication.setMaternityNurse(maternityNurse);

            indicationRepository.save(indication);
            return indication.getIndicationId();
        }

        return null;
    }
}