package com.project.kraamzicht.dtos;


import com.project.kraamzicht.models.Authority;
import com.project.kraamzicht.models.UserEntity;

import java.util.Set;

public class UserEntityDto extends UserEntity {
    private String username;
    private String password;
    private Boolean enabled;
    private Set<Authority> authorities;

    public UserEntityDto() {
        // Default constructor
    }

    public UserEntityDto(String username, String password, Boolean enabled, Set<Authority> authorities) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

//    public static UserEntityDto fromUserEntity(UserEntity userEntity) {
//        UserEntityDto dto = new UserEntityDto();
//        dto.setUsername(userEntity.getUsername());
//        dto.setPassword(userEntity.getPassword());
//        dto.setEnabled(userEntity.getEnabled());
//        dto.setAuthorities(userEntity.getAuthorities());
//
//        return dto;
//    }

    public static UserEntityDto fromUserEntity(UserEntity userEntity) {
        UserEntityDto dto = new UserEntityDto();
        dto.setUsername(userEntity.getUsername());
        dto.setPassword(userEntity.getPassword());
        dto.setAuthorities(userEntity.getAuthorities());
        dto.setEnabled(userEntity.getEnabled());
        return dto;
    }

    public static UserEntity toUserEntity(UserEntityDto userEntityDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userEntityDto.getUsername());
        userEntity.setPassword(userEntityDto.getPassword());
        userEntity.setAuthorities(userEntityDto.getAuthorities());
        userEntity.setEnabled(userEntityDto.getEnabled());

        return userEntity;
    }

    public void setApikey(String randomString) {
    }
}