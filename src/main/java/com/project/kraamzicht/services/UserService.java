package com.project.kraamzicht.services;
import com.project.kraamzicht.dtos.UserDto;
import com.project.kraamzicht.exceptions.RecordNotFoundException;
import com.project.kraamzicht.models.Authority;
import com.project.kraamzicht.models.UserEntity;
import com.project.kraamzicht.repositories.UserEntityRepository;
import com.project.kraamzicht.utils.RandomStringGenerator;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserEntityRepository userEntityRepository;

    public UserService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public List<UserDto> getUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<UserEntity> list = userEntityRepository.findAll();
        for (UserEntity user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }

    public UserDto getUser(String username) {
        UserDto dto = new UserDto();
        Optional<UserEntity> user = userEntityRepository.findById(username);
        if (user.isPresent()) {
            dto = fromUser(user.get());
        } else {
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }

    public boolean userExists(String username) {
        return userEntityRepository.existsById(username);
    }

    public String createUser(UserDto userDto) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        userDto.setApikey(randomString);
        UserEntity newUser = userEntityRepository.save(toUser(userDto));
        return newUser.getUsername();
    }

    public void deleteUser(String username) {
        userEntityRepository.deleteById(username);
    }

    public void updateUser(String username, UserDto newUser) {
        if (!userEntityRepository.existsById(username)) throw new RecordNotFoundException();
        UserEntity user = userEntityRepository.findById(username).get();
        user.setPassword(newUser.getPassword());
        userEntityRepository.save(user);
    }

    public Set<Authority> getAuthorities(String username) {
        if (!userEntityRepository.existsById(username)) throw new UsernameNotFoundException(username);
        UserEntity user = userEntityRepository.findById(username).get();
        UserDto userDto = fromUser(user);
        return userDto.getAuthorities();
    }

//    public void addAuthority(String username, String authority) {
//        if (!userEntityRepository.existsById(username)) throw new UsernameNotFoundException(username);
//        UserEntity user = userEntityRepository.findById(username).get();
//        user.addAuthority(new Authority(username, authority));
//        userEntityRepository.save(user);
//    }
//
//    public void removeAuthority(String username, String authority) {
//        if (!userEntityRepository.existsById(username)) throw new UsernameNotFoundException(username);
//        UserEntity user = userEntityRepository.findById(username).get();
//        Authority authorityToRemove = user.getAuthorities().stream()
//                .filter(a -> a.getAuthority().equalsIgnoreCase(authority))
//                .findAny().orElseThrow(() -> new RecordNotFoundException("Authority not found"));
//        user.removeAuthority(authorityToRemove);
//        userEntityRepository.save(user);
//    }

    public static UserDto fromUser(UserEntity user) {
        var dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setAuthorities(user.getAuthorities());
        return dto;
    }

    public UserEntity toUser(UserDto userDto) {
        var user = new UserEntity();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        return user;
    }
}