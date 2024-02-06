package com.project.kraamzicht.controllers;

import com.project.kraamzicht.dtos.UserEntityDto;
import com.project.kraamzicht.models.UserEntity;
import com.project.kraamzicht.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<UserEntityDto>> getUsers() {
        List<UserEntityDto> userEntityDtos = userService.getUsers();
        return ResponseEntity.ok().body(userEntityDtos);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserEntity> getUser(@PathVariable("username") String username) {
        UserEntity optionalUser = userService.getUser(username);
        return ResponseEntity.ok().body(optionalUser);
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserEntityDto> createUser(@RequestBody UserEntityDto dto) {;

        String newUsername = UserService.createUserEntity((UserEntityDto) dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<UserEntityDto> updateUser(@PathVariable("username") String username, @RequestBody UserEntityDto dto) {
        userService.updateUser(username, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

}