package com.project.kraamzicht.controllers;

import com.project.kraamzicht.dtos.UserEntityDto;
import com.project.kraamzicht.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<UserEntityDto> getUser(@PathVariable("username") String username) {
        UserEntityDto optionalUser = userService.getUser(username);
        return ResponseEntity.ok().body(optionalUser);
    }

//    @PostMapping(value = "")
//    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {
//        String newUsername = userService.createUser(dto);
//        userService.addAuthority(newUsername, "ROLE_USER");
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
//                .buildAndExpand(newUsername).toUri();
//
//        return ResponseEntity.created(location).build();
//    }

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

//    @GetMapping(value = "/{username}/authorities")
//    public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {
//        return ResponseEntity.ok().body(userService.getAuthority(username));
//    }

//    @PostMapping(value = "/{username}/authorities")
//    public ResponseEntity<Object> addUserAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) {
//        try {
//            String authorityName = (String) fields.get("authority");
//            userService.addAuthority(username, authorityName);
//            return ResponseEntity.noContent().build();
//        } catch (Exception ex) {
//            throw new BadRequestException();
//        }
//    }

//    @DeleteMapping(value = "/{username}/authorities/{authority}")
//    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("authority") String authority) {
//        userService.removeAuthority(username, authority);
//        return ResponseEntity.noContent().build();
//    }
}