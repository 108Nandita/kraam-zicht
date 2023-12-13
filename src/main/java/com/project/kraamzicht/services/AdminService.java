package com.project.kraamzicht.services;


import com.project.kraamzicht.dtos.AdminDto;
import com.project.kraamzicht.dtos.UserDto;
import com.project.kraamzicht.dtos.UserEntityDto;
import com.project.kraamzicht.exceptions.RecordNotFoundException;
import com.project.kraamzicht.models.*;
import com.project.kraamzicht.repositories.AdminRepository;
import com.project.kraamzicht.repositories.ClientRepository;
import com.project.kraamzicht.repositories.MaternityNurseRepository;
import com.project.kraamzicht.repositories.MidwifeRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.project.kraamzicht.dtos.AdminDto.fromAdmin;
import static com.project.kraamzicht.dtos.ClientDto.fromClient;
import static com.project.kraamzicht.dtos.MaternityNurseDto.fromMaternityNurse;
import static com.project.kraamzicht.dtos.MidwifeDto.fromMidwife;

@Service
public class AdminService {


    private final AdminRepository adminRepository;
    private final MaternityNurseRepository maternityNurseRepository;

    private final ClientRepository clientRepository;

    private final MidwifeRepository midwifeRepository;

    public AdminService(AdminRepository adminRepository, MaternityNurseRepository maternityNurseRepository, ClientRepository clientRepository, MidwifeRepository midwifeRepository) {
        this.adminRepository = adminRepository;
        this.maternityNurseRepository = maternityNurseRepository;
        this.clientRepository = clientRepository;
        this.midwifeRepository = midwifeRepository;
    }
    public List<UserDto> getAllUsers() {
        // Implementatie voor het ophalen van alle gebruikers
        return null;
    }

    public List<UserDto> getUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<Admin> adminList = adminRepository.findAll();
        List<MaternityNurse> maternityNurseList = maternityNurseRepository.findAll();
        List<Client> clientList = clientRepository.findAll();
        List<Midwife> midwifeList = midwifeRepository.findAll();
        for (Admin admin : adminList) {
            collection.add(fromAdmin(admin));
        }
        for (MaternityNurse maternityNurse : maternityNurseList) {
            collection.add(fromMaternityNurse(maternityNurse));
        }
        for (Client client : clientList) {
            collection.add(fromClient(client));
        }
        for (Midwife midwife : midwifeList) {
            collection.add(fromMidwife(midwife));
        }
        return collection;
    }

//    public void createAdmin(UserDto adminDto) {
//        Admin admin = adminDto.toAdmin();
//    }

    public UserEntityDto getUser(String username) {
        // Implementatie voor het ophalen van een specifieke gebruiker
        return null;
    }

    public List<UserEntityDto> getAllUserData() {
        // Implementatie voor het ophalen van alle gebruikersgegevens
        return null;
    }



//    public void addAuthority(String username, String authority) {
//        if (!adminRepository.existsById(Long.valueOf(username))) throw new UsernameNotFoundException(username);
//        Admin admin = adminRepository.findById(Long.valueOf(username)).orElseThrow(() -> new RecordNotFoundException("Admin not found"));
//        admin.addAuthority(new Authority(username, authority));
//        adminRepository.save(admin);
//    }

//    public void removeAuthority(String username, String authority) {
//        if (!adminRepository.existsById(Long.valueOf(username))) throw new UsernameNotFoundException(username);
//        Admin admin = adminRepository.findById(Long.valueOf(username)).orElseThrow(() -> new RecordNotFoundException("Admin not found"));
//        UserEntityDto authorityToRemove = admin.getAuthorities().stream()
//                .filter(a -> a.getAuthority().equalsIgnoreCase(authority))
//                .findAny().orElseThrow(() -> new RecordNotFoundException("Authority not found"));
//        admin.removeAuthority(authorityToRemove);
//        adminRepository.save(admin);
//    }

    public void createAdmin(AdminDto adminDto) {

    }
}
