package com.project.kraamzicht.controllers;

import com.project.kraamzicht.dtos.*;
import com.project.kraamzicht.exceptions.RecordNotFoundException;
import com.project.kraamzicht.repositories.AdminRepository;
import com.project.kraamzicht.services.AdminService;
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

    @PutMapping("/updateUserDetails/{username}")
    public ResponseEntity<String> updateUserDetails(@PathVariable String username, @RequestBody UserDetailsDto userDetailsDto) {
        adminService.updateUserDetails(username, userDetailsDto);
        return ResponseEntity.ok("User details updated successfully.");
    }

    @PutMapping("/updateContactDetails/{username}")
    public ResponseEntity<String> updateContactDetails(@PathVariable String username, @RequestBody ContactDetailsDto contactDetailsDto) {
        adminService.updateContactDetails(username, contactDetailsDto);
        return ResponseEntity.ok("Contact details updated successfully.");
    }

    @DeleteMapping("/deleteAdmin/{username}")
    public ResponseEntity<String> deleteAdmin(@PathVariable String username) {
        adminService.deleteAdmin(username);
        return ResponseEntity.ok("Admin deleted successfully.");
    }

}