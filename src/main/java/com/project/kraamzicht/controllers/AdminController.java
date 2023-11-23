package com.project.kraamzicht.controllers;

import com.project.kraamzicht.dtos.UserDto;
import com.project.kraamzicht.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Endpoint om alle gebruikers op te halen
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = adminService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Endpoint om een nieuwe gebruiker aan te maken
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
        adminService.createUser(userDto);
        return ResponseEntity.ok("Gebruiker succesvol aangemaakt");
    }

    // Endpoint om alle gegevens van een specifieke gebruiker op te halen
    @GetMapping("/user/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable String username) {
        UserDto user = adminService.getUser(username);
        return ResponseEntity.ok(user);
    }

    // Endpoint om alle gegevens van alle gebruikers op te halen
    @GetMapping("/allUserData")
    public ResponseEntity<List<UserDto>> getAllUserData() {
        List<UserDto> users = adminService.getAllUserData();
        return ResponseEntity.ok(users);
    }
}