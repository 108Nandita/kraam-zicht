package com.project.kraamzicht.services;


import com.project.kraamzicht.dtos.*;
import com.project.kraamzicht.dtos.AdminDto;
import com.project.kraamzicht.dtos.UserEntityDto;
import com.project.kraamzicht.dtos.UserDetailsDto;
import com.project.kraamzicht.dtos.ContactDetailsDto;
import com.project.kraamzicht.exceptions.RecordNotFoundException;
import com.project.kraamzicht.models.*;
import com.project.kraamzicht.models.UserEntity;
import com.project.kraamzicht.repositories.*;
import com.project.kraamzicht.utils.RandomStringGenerator;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.project.kraamzicht.dtos.AdminDto.fromAdmin;
import static com.project.kraamzicht.dtos.AdminDto.toAdmin;
import static com.project.kraamzicht.dtos.ClientDto.fromClient;
import static com.project.kraamzicht.dtos.MaternityNurseDto.fromMaternityNurse;
import static com.project.kraamzicht.dtos.MidwifeDto.fromMidwife;



@Service
@Transactional
public class AdminService {


    private static AdminRepository adminRepository;
    private static UserEntity userEntityDto;
    private final MaternityNurseRepository maternityNurseRepository;
    private final ClientRepository clientRepository;
    private final MidwifeRepository midwifeRepository;

    private final UserEntityRepository userEntityRepository;
    private static UserService userService;



    public AdminService(
            AdminRepository adminRepository,
            MaternityNurseRepository maternityNurseRepository,
            ClientRepository clientRepository,
            MidwifeRepository midwifeRepository,
            UserEntityRepository userEntityRepository,
            UserService userService) {
        this.adminRepository = adminRepository;
        this.maternityNurseRepository = maternityNurseRepository;
        this.clientRepository = clientRepository;
        this.midwifeRepository = midwifeRepository;
        this.userEntityRepository = userEntityRepository;
        this.userService = userService;
    }
    public void setUserEntityDto(UserEntity userEntityDto) {
        this.userEntityDto = userEntityDto;
    }

    public List<UserDto> getAllUsers() {
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

    public List<UserDto> getAllAdmins() {
        List<UserDto> collection = new ArrayList<>();
        List<Admin> adminList = adminRepository.findAll();

        for (Admin admin : adminList) {
            collection.add(fromAdmin(admin));
        }

        return collection;
    }

    public AdminDto getAdmin(String username) {
        Admin admin = adminRepository.findAdminByUsername(username);

        if (admin == null) {

            throw new RecordNotFoundException("Admin not found with username: " + username);
        }
        return AdminDto.fromAdmin(admin);
    }

    public UserDto getUserByUsername(String username) {
        Admin admin = adminRepository.findAdminByUsername(username);
        if (admin != null) {
            return AdminDto.fromAdmin(admin);
        }

        MaternityNurse maternityNurse = maternityNurseRepository.findMaternityNurseByUsername(username);
        if (maternityNurse != null) {
            return MaternityNurseDto.fromMaternityNurse(maternityNurse);
        }

        Midwife midwife = midwifeRepository.findMidwifeByUsername(username);
        if (midwife != null) {
            return MidwifeDto.fromMidwife(midwife);
        }

        Client client = clientRepository.findClientByUsername(username);
        if (client != null) {
            return ClientDto.fromClient(client);
        }

        throw new RecordNotFoundException("User not found with username: " + username);
    }

    public static String createAdmin(AdminDto adminDto) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        adminDto.setApikey(randomString);

        UserEntityDto userEntityDto = userService.getUser(adminDto.getUsername());
        UserEntity userEntity = UserEntityDto.toUserEntity(userEntityDto);
        Admin newAdmin = toAdmin(adminDto);
        newAdmin.setUserEntity(userEntity);
        adminRepository.save(newAdmin);
        return newAdmin.getUsername();
    }

    public List<UserEntityDto> getAllUserData() {
        // Implementatie voor het ophalen van alle gebruikersgegevens
        return null;
    }




    public void addAuthority(String username, String authority) {
        UserEntity userEntity = userEntityRepository.findByUsername(username);
        if (userEntity == null) {
            throw new RecordNotFoundException("UserEntity not found with username: " + username);
        }
        Authority authorityUser = new Authority(username,(authority));
        userEntity.addAuthority(authorityUser);
        userEntityRepository.save(userEntity);

    }


    public void updateUserDetails(String username, UserDetailsDto userDetailsDto) {
        adminRepository.updateUserDetails(username, userDetailsDto);
    }

    public void updateContactDetails(String username, ContactDetailsDto contactDetailsDto) {
        adminRepository.updateContactDetails(username, contactDetailsDto);
    }

    public void deleteAdmin(String username) {
        adminRepository.deleteAdminByUsername(username);
    }

}
