package com.project.kraamzicht.controllers;

import com.project.kraamzicht.dtos.*;
import com.project.kraamzicht.exceptions.RecordNotFoundException;
import com.project.kraamzicht.repositories.MaternityNurseRepository;
import com.project.kraamzicht.services.MaternityNurseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/maternityNurse")
public class MaternityNurseController {

    private final MaternityNurseService maternityNurseService;
    private final MaternityNurseRepository maternityNurseRepository;

    public MaternityNurseController(MaternityNurseService maternityNurseService, MaternityNurseRepository maternityNurseRepository) {
        this.maternityNurseService = maternityNurseService;
        this.maternityNurseRepository = maternityNurseRepository;
    }

    @GetMapping("/maternityNurses")
    public ResponseEntity<List<UserDto>> getAllMaternityNurses() {
        List<UserDto> maternityNurses = maternityNurseService.getAllMaternityNurses();
        return ResponseEntity.ok(maternityNurses);
    }

    @GetMapping("/maternityNurse/{username}")
    public ResponseEntity<UserDto> getMaternityNurse(@PathVariable String username) {
        try {
            UserDto maternityNurse = maternityNurseService.getMaternityNurseByUsername(username);
            return ResponseEntity.ok(maternityNurse);
        } catch (RecordNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getClientFilesByMaternityNurse/{kckzNumber}")
    public ResponseEntity<List<ClientFileDto>> getClientFilesByMaternityNurseKckzNumber(@PathVariable long kckzNumber) {
        List<ClientFileDto> clientFiles = maternityNurseService.getClientFilesByMaternityNurseKckzNumber(kckzNumber);
        return ResponseEntity.ok(clientFiles);
    }


    @PostMapping("/createMaternityNurse")
    public ResponseEntity<Object> createMaternityNurse(@RequestBody MaternityNurseDto dto) {

        String newUsername = maternityNurseService.createMaternityNurse((MaternityNurseDto) dto);
        maternityNurseService.addAuthority(newUsername, "ROLE_MATERNITY_NURSE");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }


    @PutMapping("/updateUserDetails/{username}")
    public ResponseEntity<String> updateUserDetails(@PathVariable String username, @RequestBody UserDetailsDto userDetailsDto) {
        maternityNurseService.updateUserDetails(username, userDetailsDto);
        return ResponseEntity.ok("User details updated successfully.");
    }

    @PutMapping("/updateContactDetails/{username}")
    public ResponseEntity<String> updateContactDetails(@PathVariable String username, @RequestBody ContactDetailsDto contactDetailsDto) {
        maternityNurseService.updateContactDetails(username, contactDetailsDto);
        return ResponseEntity.ok("Contact details updated successfully.");
    }


    @DeleteMapping("/deleteMaternityNurse/{username}")
    public ResponseEntity<String> deleteMaternityNurse(@PathVariable String username) {
        maternityNurseService.deleteMaternityNurse(username);
        return ResponseEntity.ok("Maternity Nurse deleted successfully.");
    }
}
