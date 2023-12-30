package com.project.kraamzicht.repositories;

import com.project.kraamzicht.models.Admin;
import com.project.kraamzicht.models.Client;
import com.project.kraamzicht.models.MaternityNurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin, String> {
    @Query("SELECT a FROM Admin a WHERE a.username = :username")
    Admin findAdminByUsername(@Param("username") String username);
}