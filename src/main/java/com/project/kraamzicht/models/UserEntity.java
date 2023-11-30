package com.project.kraamzicht.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

//    @Column
//    private String authority;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    private String surname;
//
//    @Column
//    @Temporal(TemporalType.DATE)
//    private LocalDate dob;
//
//    private String address;
//
//    private String postalcode;
//
//    private String place;
//
//    private String phoneNr;
//
//    @Column(nullable = false)
//    private String email;
//
//    @Column(nullable = false)
//    private String role;
//
//    private boolean enabled = true;
//
//    private String apikey;
//
//    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Admin admin;

    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();

    // Getters and Setters for UserEntity specific fields
//
//    public Admin getAdmin() {
//        return admin;
//    }
//
//    public void setAdmin(Admin admin) {
//        this.admin = admin;
//        admin.setUserEntity(this);
//    }

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

//    // ... (repeat for other fields)
//

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }

//    @Override
//    public void removeAuthority(Authority authority) {
//        this.authorities.remove(authority);
//    }
}
