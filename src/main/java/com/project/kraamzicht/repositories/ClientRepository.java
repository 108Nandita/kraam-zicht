package com.project.kraamzicht.repositories;

import com.project.kraamzicht.models.Client;
import com.project.kraamzicht.models.MaternityNurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, String> {
    @Query("SELECT a FROM Client a WHERE a.username = :username")
    Client findClientByUsername(@Param("username") String username);
}