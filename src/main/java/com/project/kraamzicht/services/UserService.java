package com.project.kraamzicht.services;

import com.project.kraamzicht.dtos.UserDto;
import com.project.kraamzicht.exceptions.RecordNotFoundException;
import com.project.kraamzicht.models.Authority;
import com.project.kraamzicht.models.User;
import com.project.kraamzicht.repositories.UserRepository;
import com.project.kraamzicht.utils.RandomStringGenerator;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserDto> getUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for (User user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }

    public UserDto getUser(String username) {
        UserDto dto = new UserDto();
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()){
            dto = fromUser(user.get());
        }else {
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }

    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    public String createUser(UserDto userDto) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        userDto.setApikey(randomString);
        User newUser = userRepository.save(toUser(userDto));
        return newUser.getUsername();
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public void updateUser(String username, UserDto newUser) {
        if (!userRepository.existsById(username)) throw new RecordNotFoundException();
        User user = userRepository.findById(username).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        UserDto userDto = fromUser(user);
        return userDto.getAuthorities();
    }

    public void addAuthority(String username, String authority) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }

    public static UserDto fromUser(User user) {
        var dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setEnabled(user.isEnabled());
        dto.setApikey(user.getApikey());
        dto.setEmail(user.getEmail());
        dto.setAuthorities(user.getAuthorities());
        // Set additional properties from the extended User class
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setDob(user.getDob());
        dto.setAddress(user.getAddress());
        dto.setPostalcode(user.getPostalcode());
        dto.setPlace(user.getPlace());
        dto.setPhoneNr(user.getPhoneNr());
        dto.setRole(user.getRole());

        return dto;
    }

    public User toUser(UserDto userDto) {
        var user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEnabled(userDto.getEnabled());
        user.setApikey(userDto.getApikey());
        user.setEmail(userDto.getEmail());
        // Set additional properties from the extended UserDto class
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setDob(userDto.getDob());
        user.setAddress(userDto.getAddress());
        user.setPostalcode(userDto.getPostalcode());
        user.setPlace(userDto.getPlace());
        user.setPhoneNr(userDto.getPhoneNr());
        user.setRole(userDto.getRole());

        return user;
    }
}
