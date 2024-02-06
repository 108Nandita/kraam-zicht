package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.Client;
import com.project.kraamzicht.models.ClientFile;

import java.util.List;

public class ClientDto extends UserDto {

    private String username;
    private String clientId;
    private List<ClientFile> clientFiles;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public List<ClientFile> getClientFiles() {
        return clientFiles;
    }

    public void setClientFiles(List<ClientFile> clientFiles) {
        this.clientFiles = clientFiles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static ClientDto fromClient(Client client) {
        ClientDto dto = new ClientDto();
        // Mapping from Client to ClientDto
        dto.setUsername(client.getUsername());
        dto.setClientId(client.getClientId());
        dto.setClientFiles(client.getClientFiles());
        dto.setEnabled(client.isEnabled());
        dto.setApikey(client.getApikey());
        dto.setEmail(client.getEmail());
        dto.setName(client.getName());
        dto.setSurname(client.getSurname());
        dto.setDob(client.getDob());
        dto.setAddress(client.getAddress());
        dto.setPostalcode(client.getPostalcode());
        dto.setPlace(client.getPlace());
        dto.setPhoneNr(client.getPhoneNr());

        return dto;
    }

    public static Client toClient(ClientDto clientDto) {
        Client client = new Client();
        // Mapping from ClientDto to Client
        client.setUsername(clientDto.getUsername());
        client.setClientId(clientDto.getClientId());
        client.setClientFiles(clientDto.getClientFiles());
        client.setEnabled(clientDto.isEnabled());
        client.setApikey(clientDto.getApikey());
        client.setEmail(clientDto.getEmail());
        client.setName(clientDto.getName());
        client.setSurname(clientDto.getSurname());
        client.setDob(clientDto.getDob());
        client.setAddress(clientDto.getAddress());
        client.setPostalcode(clientDto.getPostalcode());
        client.setPlace(clientDto.getPlace());
        client.setPhoneNr(clientDto.getPhoneNr());

        return client;
    }

}