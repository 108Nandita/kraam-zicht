package com.project.kraamzicht.controllers;

import com.project.kraamzicht.dtos.ClientDto;
import com.project.kraamzicht.repositories.ClientRepository;
import com.project.kraamzicht.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    private final ClientRepository clientRepository;

    public ClientController(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @PostMapping("/createClient")
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto dto) {

        String newUsername = clientService.createClient((ClientDto) dto);
        clientService.addAuthority(newUsername, "ROLE_CLIENT");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }


}
