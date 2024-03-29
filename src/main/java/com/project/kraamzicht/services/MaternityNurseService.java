package com.project.kraamzicht.services;

import com.project.kraamzicht.dtos.*;
import com.project.kraamzicht.exceptions.RecordNotFoundException;
import com.project.kraamzicht.models.Authority;
import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.models.MaternityNurse;
import com.project.kraamzicht.models.UserEntity;
import com.project.kraamzicht.repositories.*;
import com.project.kraamzicht.utils.RandomStringGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.project.kraamzicht.dtos.MaternityNurseDto.fromMaternityNurse;
import static com.project.kraamzicht.dtos.MaternityNurseDto.toMaternityNurse;
import static com.project.kraamzicht.dtos.ClientFileDto.fromClientFile;

@Service
@Transactional
public class MaternityNurseService {
    private final MaternityNurseRepository maternityNurseRepository;
    private final ClientFileRepository clientFileRepository;
    private final UserEntityRepository userEntityRepository;
    private final UserService userService;

    public MaternityNurseService(MaternityNurseRepository maternityNurseRepository, UserEntityRepository userEntityRepository, UserService userService, UserEntityRepository userEntityRepository1, ClientFileRepository clientFileRepository) {
        this.maternityNurseRepository = maternityNurseRepository;
        this.userEntityRepository = userEntityRepository;
        this.userService = userService;
        this.clientFileRepository = clientFileRepository;
    }

    public MaternityNurse findMaternityNurseByKckzNumber(long kckzNumber) {
        return maternityNurseRepository.findByKckzNumber(kckzNumber);
    }

    public List<UserDto> getAllMaternityNurses() {
        List<UserDto> collection = new ArrayList<>();
        List<MaternityNurse> maternityNurseList = maternityNurseRepository.findAll();

        for (MaternityNurse maternityNurse : maternityNurseList) {
            collection.add(fromMaternityNurse(maternityNurse));
        }

        return collection;

    }

    public UserDto getMaternityNurseByUsername(String username) {
        MaternityNurse maternityNurse = maternityNurseRepository.findMaternityNurseByUsername(username);

        if (maternityNurse != null) {
            return MaternityNurseDto.fromMaternityNurse(maternityNurse);
        }

        throw new RecordNotFoundException("Maternity Nurse not found with username: " + username);
    }

    public List<ClientFileDto> getClientFilesByMaternityNurseKckzNumber(long kckzNumber) {
        MaternityNurse maternityNurse = maternityNurseRepository.findByKckzNumber(kckzNumber);

        if (maternityNurse != null) {
            List<ClientFile> clientFiles = clientFileRepository.findByMaternityNurse(maternityNurse);
            return clientFiles.stream()
                    .map(ClientFileDto::fromClientFile)
                    .collect(Collectors.toList());
        }

        throw new RecordNotFoundException("Maternity Nurse not found with kckzNumber: " + kckzNumber);
    }


    public String createMaternityNurse(MaternityNurseDto maternityNurseDto) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        maternityNurseDto.setApikey(randomString);

        UserEntityDto userEntityDto = userService.getUser(maternityNurseDto.getUsername());
        UserEntity userEntity = UserEntityDto.toUserEntity(userEntityDto);
        MaternityNurse newMaternityNurse = toMaternityNurse(maternityNurseDto);
        newMaternityNurse.setUserEntity(userEntity);
        maternityNurseRepository.save(newMaternityNurse);

        return newMaternityNurse.getUsername();
    }

    public void addAuthority(String username, String authority) {
        UserEntity userEntity = userEntityRepository.findByUsername(username);

        if (userEntity == null) {
            throw new RecordNotFoundException("UserEntity not found with username: " + username);
        }

        Authority authorityUser = new Authority(username, authority);
        userEntity.addAuthority(authorityUser);
        userEntityRepository.save(userEntity);
    }

    public void updateUserDetails(String username, UserDetailsDto userDetailsDto) {
        maternityNurseRepository.updateUserDetails(username, userDetailsDto);
    }

    public void updateContactDetails(String username, ContactDetailsDto contactDetailsDto) {
        maternityNurseRepository.updateContactDetails(username, contactDetailsDto);
    }

    public void deleteMaternityNurse(String username) {
        maternityNurseRepository.deleteMaternityNurseByUsername(username);
    }

    public void updateMaternityNurseKckzNumber(MaternityNurse existingMaternityNurse) {
        maternityNurseRepository.save(existingMaternityNurse);
    }

}