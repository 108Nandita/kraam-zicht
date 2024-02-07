package com.project.kraamzicht.controllers;

import com.project.kraamzicht.dtos.IndicationDto;
import com.project.kraamzicht.services.IndicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("indications")
public class IndicationController {

    private final IndicationService indicationService;

    @Autowired
    public IndicationController(IndicationService indicationService) {
        this.indicationService = indicationService;
    }

    @PostMapping("/createIndication/{clientFileId}/{maternityNurseKckzNumber}")
    public ResponseEntity<Long> createIndication(@RequestBody IndicationDto indicationDto,
                                                 @PathVariable Long clientFileId,
                                                 @PathVariable Long maternityNurseKckzNumber) {
        Long newIndicationId = indicationService.createIndication(indicationDto, clientFileId, maternityNurseKckzNumber);
        return ResponseEntity.ok(newIndicationId);
    }
}