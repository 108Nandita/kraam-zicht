package com.project.kraamzicht.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "admins")
@DiscriminatorValue("Admin")
public class Admin extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private long personnelNumber;

    @OneToMany(mappedBy = "admin")
    private List<Client> createdClients;

    public long getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(long personnelNumber) {
        this.personnelNumber = personnelNumber;
    }
}