package com.project.kraamzicht.dtos;

import com.project.kraamzicht.models.*;
import com.project.kraamzicht.dtos.ClientFileDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserDto {
    private String username;
    private String password;
    public Boolean enabled;
    private String name;
    private String surname;
    private LocalDate dob;
    private String address;
    private String postalcode;
    private String place;
    private String phoneNr;
    private String email;
    private String apikey;

    private long agbCode;

    private String certification;

    private List<Indication> approvedIndications;

    private String clientId;

    private List<ClientFile> clientFiles;

    private String kckzNumber;

    private List<IndicationDto> indications;

    private long personnelNumber;

    private List<UserDto> createdMaternityNurses;

    private List<UserDto> createdClients;

    private List<ClientFileDto> createdClientFiles;

    private List<UserDto> createdMidwives;


    public Set<Authority> authorities;

    public UserDto() {
    }

    public UserDto(String username, String password, Boolean enabled,
                   String name, String surname, LocalDate dob, String address,
                   String postalcode, String place, String phoneNr, String email, String apikey,
                   long agbCode, String certification, List<Indication> approvedIndications,
                   Set<Authority> authorities, String clientId, List<ClientFile> clientFiles,
                   long personnelNumber, List<UserDto> createdMaternityNurses,
                   List<UserDto> createdClients, List<ClientFileDto> createdClientFiles,
                   List<UserDto> createdMidwives) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.address = address;
        this.postalcode = postalcode;
        this.place = place;
        this.phoneNr = phoneNr;
        this.email = email;
        this.apikey = apikey;
        this.agbCode = agbCode;
        this.certification = certification;
        this.approvedIndications = approvedIndications;
        this.authorities = authorities;
        this.clientId = clientId;
        this.clientFiles = clientFiles;
        this.personnelNumber = personnelNumber;
        this.createdMaternityNurses = createdMaternityNurses;
        this.createdClients = createdClients;
        this.createdClientFiles = createdClientFiles;
        this.createdMidwives = createdMidwives;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public Boolean getEnabled() {
        return enabled;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }


    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public long getAgbCode() {
        return agbCode;
    }

    public void setAgbCode(long agbCode) {
        this.agbCode = agbCode;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }


    public List<Indication> getApprovedIndications() {
        return approvedIndications;
    }

    public void setApprovedIndications(List<Indication> approvedIndications) {
        this.approvedIndications = approvedIndications;
    }

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

    public void setPersonnelNumber(long personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public List<UserDto> getCreatedMaternityNurses() {
        return createdMaternityNurses;
    }

    public void setCreatedMaternityNurses(List<UserDto> createdMaternityNurses) {
        this.createdMaternityNurses = createdMaternityNurses;
    }

    public List<UserDto> getCreatedClients() {
        return createdClients;
    }

    public void setCreatedClients(List<UserDto> createdClients) {
        this.createdClients = createdClients;
    }

    public List<ClientFileDto> getCreatedClientFiles() {
        return createdClientFiles;
    }

    public void setCreatedClientFiles(List<ClientFileDto> createdClientFiles) {
        this.createdClientFiles = createdClientFiles;
    }

    public List<UserDto> getCreatedMidwives() {
        return createdMidwives;
    }

    public void setCreatedMidwives(List<UserDto> createdMidwives) {
        this.createdMidwives = createdMidwives;
    }

    public long getPersonnelNumber() {
        return personnelNumber;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public static UserDto fromMidwife(Midwife midwife) {
        UserDto dto = new UserDto();
        dto.setAgbCode(midwife.getAgbCode());
        dto.setCertification(midwife.getCertification());
        dto.setApprovedIndications(midwife.getApprovedIndications());
        dto.setUsername(midwife.getUsername());
        dto.setPassword(midwife.getPassword());
        dto.setEnabled(midwife.isEnabled());
        dto.setApikey(midwife.getApikey());
        dto.setEmail(midwife.getEmail());
        dto.setAuthorities(midwife.getAuthorities());
        dto.setName(midwife.getName());
        dto.setSurname(midwife.getSurname());
        dto.setDob(midwife.getDob());
        dto.setAddress(midwife.getAddress());
        dto.setPostalcode(midwife.getPostalcode());
        dto.setPlace(midwife.getPlace());
        dto.setPhoneNr(midwife.getPhoneNr());

        return dto;
    }
    public static UserDto fromClient(Client client) {
        UserDto dto = new UserDto();
        dto.setClientId(client.getClientId());
        dto.setUsername(client.getUsername());
        dto.setPassword(client.getPassword());
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

    public static UserDto fromMaternityNurse(MaternityNurse maternityNurse) {
        UserDto dto = new UserDto();
        // Mapping from MaternityNurse to MaternityNurseDto
        dto.setKckzNumber(maternityNurse.getKckzNumber());
//        dto.setClientFiles(ClientFileDto.fromClientFiles(Client.getClientFiles()));
//        dto.setClientFiles(ClientFileDto.convertListFromClientFiles(Client.getClientFiles()));
        dto.setClientFiles(ClientFileDto.convertListFromClientFiles(clientInstance.getClientFiles()));
        dto.setIndications(IndicationDto.fromIndications(maternityNurse.getIndications()));
        // Set common properties from UserDto class (assuming UserDto has similar fields)
        dto.setUsername(maternityNurse.getUsername());
        dto.setPassword(maternityNurse.getPassword());
        dto.setEnabled(maternityNurse.isEnabled());
        dto.setApikey(maternityNurse.getApikey());
        dto.setEmail(maternityNurse.getEmail());
        dto.setName(maternityNurse.getName());
        dto.setSurname(maternityNurse.getSurname());
        dto.setDob(maternityNurse.getDob());
        dto.setAddress(maternityNurse.getAddress());
        dto.setPostalcode(maternityNurse.getPostalcode());
        dto.setPlace(maternityNurse.getPlace());
        dto.setPhoneNr(maternityNurse.getPhoneNr());

        return dto;
    }

    public static UserDto fromAdmin(Admin admin) {
        UserDto dto = new UserDto();

        // Vul attributen van User in
        dto.setUsername(admin.getUsername());
        dto.setPassword(admin.getPassword());
        dto.setApikey(admin.getApikey());
        dto.setEmail(admin.getEmail());
        dto.setName(admin.getName());
        dto.setSurname(admin.getSurname());
        dto.setDob(admin.getDob());
        dto.setAddress(admin.getAddress());
        dto.setPostalcode(admin.getPostalcode());
        dto.setPlace(admin.getPlace());
        dto.setPhoneNr(admin.getPhoneNr());
        dto.setEnabled(admin.isEnabled());
        dto.setPersonnelNumber(admin.getPersonnelNumber());
        dto.setCreatedMaternityNurses(fromMaternityNurses(admin.getCreatedMaternityNurses()));
        dto.setCreatedClients(fromClients(admin.getCreatedClients()));
        dto.setCreatedClientFiles(fromClientFiles(admin.getCreatedClientFiles()));
        dto.setCreatedMidwives(fromMidwives(admin.getCreatedMidwives()));

        return dto;
    }

    private static List<UserDto> fromMaternityNurses(List<MaternityNurse> maternityNurses) {
        List<UserDto> UserDto = new ArrayList<>();
        for (MaternityNurse maternityNurse : maternityNurses) {
            UserDto dto = new UserDto();
            UserDto.add(dto);
        }
        return UserDto;
    }

    private static List<UserDto> fromClients(List<Client> clients) {
        List<UserDto> UserDto = new ArrayList<>();
        for (Client client : clients) {
            UserDto dto = new UserDto();
            UserDto.add(dto);
        }
        return UserDto;
    }

    private static List<ClientFileDto> fromClientFiles(List<ClientFile> clientFiles) {
        List<ClientFileDto> clientFileDtos = new ArrayList<>();
        for (ClientFile clientFile : clientFiles) {
            ClientFileDto dto = new ClientFileDto();
            clientFileDtos.add(dto);
        }
        return clientFileDtos;
    }

    private static List<UserDto> fromMidwives(List<Midwife> midwives) {
        List<UserDto> UserDto = new ArrayList<>();
        for (Midwife midwife : midwives) {
            UserDto dto = new UserDto();
            UserDto.add(dto);
        }
        return UserDto;
    }

    public String getKckzNumber() {
        return kckzNumber;
    }

    public void setKckzNumber(String kckzNumber) {
        this.kckzNumber = kckzNumber;
    }

    public List<Indication> getIndications() {
        return indications;
    }

    public void setIndications(List<Indication> indications) {
        this.indications = indications;
    }
}



