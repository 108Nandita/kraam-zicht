package com.project.kraamzicht.services;


import com.project.kraamzicht.dtos.AdminDto;
import com.project.kraamzicht.dtos.UserDto;
import com.project.kraamzicht.exceptions.RecordNotFoundException;
import com.project.kraamzicht.models.Admin;
import com.project.kraamzicht.models.Authority;
import com.project.kraamzicht.models.MaternityNurse;
import com.project.kraamzicht.repositories.AdminRepository;
import com.project.kraamzicht.repositories.MaternityNurseRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AdminService {


    private final AdminRepository adminRepository; // Verander dit veld naar AdminRepository
    private final MaternityNurseRepository maternityNurseRepository; // Verander dit veld naar AdminRepository

    public AdminService(AdminRepository adminRepository, MaternityNurseRepository maternityNurseRepository) {
        this.adminRepository = adminRepository;
        this.maternityNurseRepository = maternityNurseRepository;
    }
    public List<UserDto> getAllUsers() {
        // Implementatie voor het ophalen van alle gebruikers
        return null;
    }

    public List<UserDto> getUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<Admin> adminList = adminRepository.findAll();
        List<MaternityNurse> maternityNurseList = maternityNurseRepository.findAll();
        for (Admin admin : adminList) {
//            collection.add(fromAdmin(admin));
//        }
//        for (MaternityNurse maternityNurse : maternityNurseList) {
//            collection.add(fromMaternityNurse(maternityNurse));
        }
        return collection;
    }

    public void createAdmin(AdminDto adminDto) {
        Admin admin = adminDto.toAdmin();
    }

    public UserDto getUser(String username) {
        // Implementatie voor het ophalen van een specifieke gebruiker
        return null;
    }

    public List<UserDto> getAllUserData() {
        // Implementatie voor het ophalen van alle gebruikersgegevens
        return null;
    }

    public UserDto createUserDto(String username, String password, Boolean enabled, String authority,
                                 String name, String surname, LocalDate dob, String address,
                                 String postalcode, String place, String phoneNr, String email,
                                 String role, String apikey, Set<Authority> authorities) {
        return new UserDto(username, password, enabled, authority, name, surname, dob,
                address, postalcode, place, phoneNr, email, role, apikey, authorities);
    }

    public void addAuthority(String username, String authority) {
        if (!adminRepository.existsById(Long.valueOf(username))) throw new UsernameNotFoundException(username);
        Admin admin = adminRepository.findById(Long.valueOf(username)).orElseThrow(() -> new RecordNotFoundException("Admin not found"));
        admin.addAuthority(new Authority(username, authority));
        adminRepository.save(admin);
    }

    public void removeAuthority(String username, String authority) {
        if (!adminRepository.existsById(Long.valueOf(username))) throw new UsernameNotFoundException(username);
        Admin admin = adminRepository.findById(Long.valueOf(username)).orElseThrow(() -> new RecordNotFoundException("Admin not found"));
        Authority authorityToRemove = admin.getAuthorities().stream()
                .filter(a -> a.getAuthority().equalsIgnoreCase(authority))
                .findAny().orElseThrow(() -> new RecordNotFoundException("Authority not found"));
        admin.removeAuthority(authorityToRemove);
        adminRepository.save(admin);
    }

}
