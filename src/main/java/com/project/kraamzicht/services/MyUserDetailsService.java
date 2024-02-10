package com.project.kraamzicht.services;

import com.project.kraamzicht.models.Authority;
import com.project.kraamzicht.models.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        UserEntity userEntityDto = userService.getUser(username);


        String password = userEntityDto.getPassword();

        Set<Authority> authorities = userEntityDto.getAuthorities();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority: authorities) {

                grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));

        }

        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
    }
    }
