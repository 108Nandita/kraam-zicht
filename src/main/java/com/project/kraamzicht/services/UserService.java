package com.project.kraamzicht.services;
import com.project.kraamzicht.dtos.UserEntityDto;
import com.project.kraamzicht.exceptions.RecordNotFoundException;
import com.project.kraamzicht.models.UserEntity;
import com.project.kraamzicht.repositories.UserEntityRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserEntityRepository userEntityRepository;

    public UserService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public List<UserEntityDto> getUsers() {
        List<UserEntityDto> collection = new ArrayList<>();
        List<UserEntity> list = userEntityRepository.findAll();
        for (UserEntity user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }

    public UserEntityDto getUser(String username) {
        UserEntityDto dto = new UserEntityDto();
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

//    public String createUser(UserEntityDto userEntityDto) {
//        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
//        userEntityDto.setApikey(randomString);
//        UserEntity newUser = userEntityRepository.save(toUser(userEntityDto));
//        return newUser.getUsername();
//    }

    public void deleteUser(String username) {
        userEntityRepository.deleteById(username);
    }

    public void updateUser(String username, UserEntityDto newUser) {
        if (!userEntityRepository.existsById(username)) throw new RecordNotFoundException();
        UserEntity user = userEntityRepository.findById(username).get();
        user.setPassword(newUser.getPassword());
        userEntityRepository.save(user);
    }

    public String getAuthorities(String username) {
        if (!userEntityRepository.existsById(username)) throw new UsernameNotFoundException(username);
        UserEntity user = userEntityRepository.findById(username).get();
        UserEntityDto userEntityDto = fromUser(user);

        String authoritiesAsString = userEntityDto.getAuthorities().toString();

        return authoritiesAsString;
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

    public static UserEntityDto fromUser(UserEntity user) {
        var dto = new UserEntityDto();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setAuthorities(user.getAuthorities());
        return dto;
    }

    public UserEntity toUser(UserEntityDto userEntityDto) {
        var user = new UserEntity();
        user.setUsername(userEntityDto.getUsername());
        user.setPassword(userEntityDto.getPassword());

        return user;
    }
}