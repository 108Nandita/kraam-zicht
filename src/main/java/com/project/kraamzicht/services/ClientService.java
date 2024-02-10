package com.project.kraamzicht.services;

import com.project.kraamzicht.dtos.*;
import com.project.kraamzicht.exceptions.RecordNotFoundException;
import com.project.kraamzicht.models.Authority;
import com.project.kraamzicht.models.Client;
import com.project.kraamzicht.models.UserEntity;
import com.project.kraamzicht.repositories.ClientRepository;
import com.project.kraamzicht.repositories.UserEntityRepository;
import com.project.kraamzicht.utils.RandomStringGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    public List<UserDto> getAllClients() {
        List<UserDto> collection = new ArrayList<>();
        List<Client> clientList = clientRepository.findAll();

        for (Client client : clientList) {
            collection.add(fromClient(client));
        }

        return collection;
    }

    public ClientDto getClientByUsername(String username) {
        Client client = clientRepository.findClientByUsername(username);

        if (client == null) {
            throw new RecordNotFoundException("Client not found with username: " + username);
        }

        return ClientDto.fromClient(client);
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

    public void updateUserDetails(String username, UserDetailsDto userDetailsDto) {
        clientRepository.updateUserDetails(username, userDetailsDto);
    }

    public void updateContactDetails(String username, ContactDetailsDto contactDetailsDto) {
        clientRepository.updateContactDetails(username, contactDetailsDto);
    }

    public void deleteClient(String username) {
        clientRepository.deleteClientByUsername(username);
    }

}