package com.project.kraamzicht.repositories;

import com.project.kraamzicht.models.MaternityNurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaternityNurseRepository extends JpaRepository<MaternityNurse, String> {
    @Query("SELECT a FROM MaternityNurse a WHERE a.username = :username")
    MaternityNurse findMaternityNurseByUsername(@Param("username") String username);
}
