package com.project.kraamzicht.services;

import com.project.kraamzicht.dtos.UserEntityDto;
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

import static com.project.kraamzicht.dtos.UserEntityDto.fromUserEntity;
import static com.project.kraamzicht.dtos.UserEntityDto.toUserEntity;

@Service
public class UserService {
    static UserEntityRepository userEntityRepository = null;

    public UserService(UserEntityRepository userEntityRepository) {
        UserService.userEntityRepository = userEntityRepository;
    }

    public List<UserEntityDto> getUsers() {
        List<UserEntityDto> collection = new ArrayList<>();
        List<UserEntity> list = userEntityRepository.findAll();
        for (UserEntity user : list) {
            collection.add(fromUserEntity(user));
        }
        return collection;
    }

    public UserEntityDto getUser(String username) {
        UserEntityDto dto = new UserEntityDto();
        Optional<UserEntity> user = userEntityRepository.findById(username);
        if (user.isPresent()) {
            dto = fromUserEntity(user.get());
        } else {
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }

    public boolean userExists(String username) {
        return userEntityRepository.existsById(username);
    }

    public static String createUserEntity(UserEntityDto userEntityDto) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        userEntityDto.setApikey(randomString);
        UserEntity newUserEntity = userEntityRepository.save(toUserEntity(userEntityDto));
        return newUserEntity.getUsername();
    }

    public void deleteUser(String username) {
        userEntityRepository.deleteById(username);
    }

    public void updateUser(String username, UserEntityDto newUser) {
        if (!userEntityRepository.existsById(username)) throw new RecordNotFoundException();
        UserEntity user = userEntityRepository.findById(username).get();
        user.setPassword(newUser.getPassword());
        userEntityRepository.save(user);
    }
}