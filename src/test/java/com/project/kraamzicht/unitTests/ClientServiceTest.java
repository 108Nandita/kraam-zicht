package com.project.kraamzicht.unitTests;

import com.project.kraamzicht.dtos.*;
import com.project.kraamzicht.exceptions.RecordNotFoundException;
import com.project.kraamzicht.models.Client;
import com.project.kraamzicht.models.UserEntity;
import com.project.kraamzicht.repositories.ClientRepository;
import com.project.kraamzicht.repositories.UserEntityRepository;
import com.project.kraamzicht.services.ClientService;
import com.project.kraamzicht.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private UserEntityRepository userEntityRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private ClientService clientService;

    @Test
    void getAllClients_ShouldReturnListOfUserDtos() {
        // Arrange
        List<Client> clients = new ArrayList<>();
        when(clientRepository.findAll()).thenReturn(clients);

        // Act
        List<UserDto> result = clientService.getAllClients();

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void getClientByUsername_ExistingClient_ShouldReturnClientDto() {
        // Arrange
        String username = "testuser";
        Client client = new Client();
        when(clientRepository.findClientByUsername(username)).thenReturn(client);

        // Act
        ClientDto result = clientService.getClientByUsername(username);

        // Assert
        assertNotNull(result);
    }

    @Test
    void getClientByUsername_NonExistingClient_ShouldThrowRecordNotFoundException() {
        // Arrange
        String username = "nonexistentuser";
        when(clientRepository.findClientByUsername(username)).thenReturn(null);

        // Act & Assert
        assertThrows(RecordNotFoundException.class, () -> clientService.getClientByUsername(username));
    }

    @Test
    void createClient_ShouldReturnNewClientUsername() {
        // Arrange
        ClientDto clientDto = new ClientDto();
        clientDto.setUsername("testuser");
        when(userService.getUser(Mockito.anyString())).thenReturn(new UserEntityDto());
        when(clientRepository.save(any(Client.class))).thenReturn(new Client());

        // Act
        String result = clientService.createClient(clientDto);

        // Assert
        assertEquals("testuser", result);
    }

    @Test
    void addAuthority_ExistingUserEntity_ShouldAddAuthority() {
        // Arrange
        String username = "testuser";
        String authority = "ROLE_ADMIN";
        UserEntity userEntity = new UserEntity();
        when(userEntityRepository.findByUsername(username)).thenReturn(userEntity);

        // Act
        clientService.addAuthority(username, authority);

        // Assert
        assertTrue(userEntity.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(authority)));
    }

    @Test
    void addAuthority_NonExistingUserEntity_ShouldThrowRecordNotFoundException() {
        // Arrange
        String username = "nonexistentuser";
        when(userEntityRepository.findByUsername(username)).thenReturn(null);

        // Act & Assert
        assertThrows(RecordNotFoundException.class, () -> clientService.addAuthority(username, "ROLE_ADMIN"));
    }

    @Test
    void updateUserDetails_ShouldCallClientRepositoryUpdateUserDetails() {
        // Arrange
        String username = "testuser";
        UserDetailsDto userDetailsDto = new UserDetailsDto();

        // Act
        clientService.updateUserDetails(username, userDetailsDto);

        // Assert
        Mockito.verify(clientRepository).updateUserDetails(username, userDetailsDto);
    }

    @Test
    void updateContactDetails_ShouldCallClientRepositoryUpdateContactDetails() {
        // Arrange
        String username = "testuser";
        ContactDetailsDto contactDetailsDto = new ContactDetailsDto();

        // Act
        clientService.updateContactDetails(username, contactDetailsDto);

        // Assert
        Mockito.verify(clientRepository).updateContactDetails(username, contactDetailsDto);
    }

    @Test
    void deleteClient_ShouldCallClientRepositoryDeleteClientByUsername() {
        // Arrange
        String username = "testuser";

        // Act
        clientService.deleteClient(username);

        // Assert
        Mockito.verify(clientRepository).deleteClientByUsername(username);
    }
}