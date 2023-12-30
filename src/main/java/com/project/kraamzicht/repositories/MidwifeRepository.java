package com.project.kraamzicht.repositories;

import com.project.kraamzicht.models.Midwife;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MidwifeRepository extends JpaRepository<Midwife, String> {
    @Query("SELECT a FROM Midwife a WHERE a.username = :username")
    Midwife findMidwifeByUsername(@Param("username") String username);
}

