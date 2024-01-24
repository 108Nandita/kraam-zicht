package com.project.kraamzicht.services;

import com.project.kraamzicht.dtos.ClientDto;
import com.project.kraamzicht.dtos.UserEntityDto;
import com.project.kraamzicht.exceptions.RecordNotFoundException;
import com.project.kraamzicht.models.Authority;
import com.project.kraamzicht.models.Client;
import com.project.kraamzicht.models.UserEntity;
import com.project.kraamzicht.repositories.ClientRepository;
import com.project.kraamzicht.repositories.UserEntityRepository;
import com.project.kraamzicht.utils.RandomStringGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.project.kraamzicht.dtos.ClientDto.fromClient;
import static com.project.kraamzicht.dtos.ClientDto.toClient;


@Service
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;
    private final UserEntityRepository userEntityRepository;
    private final UserService userService;

    public ClientService(ClientRepository clientRepository,
                         UserEntityRepository userEntityRepository,
                         UserService userService) {
        this.clientRepository = clientRepository;
        this.userEntityRepository = userEntityRepository;
        this.userService = userService;
    }


    public String createClient(ClientDto clientDto) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        clientDto.setApikey(randomString);

        UserEntityDto userEntityDto = userService.getUser(clientDto.getUsername());
        UserEntity userEntity = UserEntityDto.toUserEntity(userEntityDto);
        Client newClient = toClient(clientDto);
        newClient.setUserEntity(userEntity);
        clientRepository.save(newClient);

        return newClient.getUsername();
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


}