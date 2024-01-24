package com.project.kraamzicht.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "authorities")
public class Authority implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String username;

    private String authority;

    public Authority() {}

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}