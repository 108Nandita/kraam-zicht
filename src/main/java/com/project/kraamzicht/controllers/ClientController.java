package com.project.kraamzicht.controllers;

import com.project.kraamzicht.dtos.ClientDto;
import com.project.kraamzicht.dtos.ContactDetailsDto;
import com.project.kraamzicht.dtos.UserDetailsDto;
import com.project.kraamzicht.dtos.UserDto;
import com.project.kraamzicht.exceptions.RecordNotFoundException;
import com.project.kraamzicht.repositories.ClientRepository;
import com.project.kraamzicht.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    private final ClientRepository clientRepository;

    public ClientController(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/clients")
    public ResponseEntity<List<UserDto>> getAllClients() {
        List<UserDto> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/client/{username}")
    public ResponseEntity<UserDto> getClient(@PathVariable String username) {
        try {
            UserDto client = clientService.getClientByUsername(username);
            return ResponseEntity.ok(client);
        } catch (RecordNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/createClient")
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto dto) {

        String newUsername = clientService.createClient((ClientDto) dto);
        clientService.addAuthority(newUsername, "ROLE_CLIENT");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/updateUserDetails/{username}")
    public ResponseEntity<String> updateUserDetails(@PathVariable String username, @RequestBody UserDetailsDto userDetailsDto) {
        clientService.updateUserDetails(username, userDetailsDto);
        return ResponseEntity.ok("User details updated successfully.");
    }

    @PutMapping("/updateContactDetails/{username}")
    public ResponseEntity<String> updateContactDetails(@PathVariable String username, @RequestBody ContactDetailsDto contactDetailsDto) {
        clientService.updateContactDetails(username, contactDetailsDto);
        return ResponseEntity.ok("Contact details updated successfully.");
    }

    @DeleteMapping("/deleteClient/{username}")
    public ResponseEntity<String> deleteClient(@PathVariable String username) {
        clientService.deleteClient(username);
        return ResponseEntity.ok("Client deleted successfully.");
    }

}
