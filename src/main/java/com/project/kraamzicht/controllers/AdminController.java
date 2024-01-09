package com.project.kraamzicht.controllers;

import com.project.kraamzicht.dtos.UserDto;
import com.project.kraamzicht.dtos.AdminDto;
import com.project.kraamzicht.exceptions.RecordNotFoundException;
import com.project.kraamzicht.models.Admin;
import com.project.kraamzicht.repositories.AdminRepository;
import com.project.kraamzicht.services.AdminService;
import com.project.kraamzicht.utils.RandomStringGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import com.project.kraamzicht.dtos.AdminDto;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final AdminRepository adminRepository;

    public AdminController(AdminService adminService, AdminRepository adminRepository) {
        this.adminService = adminService;
        this.adminRepository = adminRepository;
    }

    // Endpoint om alle gebruikers op te halen
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = adminService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/admins")
    public ResponseEntity<List<UserDto>> getAllAdmins() {
        List<UserDto> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

//    @GetMapping("/admin/{username}")
//    public ResponseEntity<AdminDto> getAdmin(@PathVariable String username) {
//        try {
//            AdminDto admin = adminService.getAdmin(username);
//            return ResponseEntity.ok(admin);
//        } catch (RecordNotFoundException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }



    // Endpoint om alle gegevens van een specifieke gebruiker op te halen
//    @GetMapping("/user/{username}")
//    public ResponseEntity<UserEntityDto> getUser(@PathVariable String username) {
//        UserEntityDto user = adminService.getUser(username);
//        return ResponseEntity.ok(user);
//    }

    @GetMapping("/user/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable String username) {
        try {
            UserDto user = adminService.getUserByUsername(username);
            return ResponseEntity.ok(user);
        } catch (RecordNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/createAdmin")
    public ResponseEntity<AdminDto> createUser(@RequestBody AdminDto dto) {;

        String newUsername = adminService.createAdmin((AdminDto) dto);
        adminService.addAuthority(newUsername, "ROLE_ADMIN");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }









}