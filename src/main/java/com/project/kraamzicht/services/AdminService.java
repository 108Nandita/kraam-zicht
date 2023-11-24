package com.project.kraamzicht.services;


import com.project.kraamzicht.dtos.AdminDto;
import com.project.kraamzicht.dtos.UserDto;
import com.project.kraamzicht.models.Admin;
import com.project.kraamzicht.models.Authority;
import com.project.kraamzicht.models.UserEntity;
import com.project.kraamzicht.repositories.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class AdminService {

    private final UserEntityRepository userEntityRepository;

    public AdminService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public List<UserDto> getAllUsers() {
        // Implementatie voor het ophalen van alle gebruikers
        return null;
    }

//    public void createUser(UserDto userDto) {
//        // Implementatie voor het aanmaken van een nieuwe gebruiker
//    }


    public void createAdmin(AdminDto adminDto) {
        Admin admin = adminDto.toAdmin();
        UserEntity userEntity = admin.toUserEntity(); // Maak UserEntity van Admin
        admin.copyToUserEntity(userEntity); // Kopieer Admin-gegevens naar UserEntity
        userEntityRepository.save(userEntity); // Sla de UserEntity op
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
}
