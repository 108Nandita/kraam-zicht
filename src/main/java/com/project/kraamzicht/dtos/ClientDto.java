//package com.project.kraamzicht.dtos;
//
//import com.project.kraamzicht.models.Admin;
//import com.project.kraamzicht.models.Authority;
//import com.project.kraamzicht.models.Client;
//import com.project.kraamzicht.models.ClientFile;
//
//import java.util.List;
//
//public class ClientDto extends UserDto {
////    private String clientId;
////    private AdminDto admin;  // AdminDto is hier niet nodig
////    private List<ClientFile> clientFiles;
//
////    public String getClientId() {
////        return clientId;
////    }
////
////    public void setClientId(String clientId) {
////        this.clientId = clientId;
////    }
////
////    public List<ClientFile> getClientFiles() {
////        return clientFiles;
////    }
////
////    public void setClientFiles(List<ClientFile> clientFiles) {
////        this.clientFiles = clientFiles;
////    }
//
//    public static ClientDto fromClient(Client client) {
//        ClientDto dto = new ClientDto();
//        // Mapping from Client to ClientDto
//        dto.setClientId(client.getClientId());
//        dto.setClientFiles(client.getClientFiles());
//        // Set common properties from User class
//        dto.setUsername(client.getUsername());
//        dto.setPassword(client.getPassword());
//        dto.setEnabled(client.isEnabled());
//        dto.setApikey(client.getApikey());
//        dto.setEmail(client.getEmail());
//        dto.setName(client.getName());
//        dto.setSurname(client.getSurname());
//        dto.setDob(client.getDob());
//        dto.setAddress(client.getAddress());
//        dto.setPostalcode(client.getPostalcode());
//        dto.setPlace(client.getPlace());
//        dto.setPhoneNr(client.getPhoneNr());
//
//        return dto;
//    }
//}