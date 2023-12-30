package com.project.kraamzicht.services;

import com.project.kraamzicht.dtos.UserDto;
import com.project.kraamzicht.dtos.UserEntityDto;
import com.project.kraamzicht.models.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;


    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntityDto userEntityDto = userService.getUser(username);


        String password = userEntityDto.getPassword();

        Set<Authority> authorities = userEntityDto.getAuthorities();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority: authorities) {
            for (String s: authority.getAuthorities()){
                grantedAuthorities.add(new SimpleGrantedAuthority(s));
            }

        }

        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
    }
    }
