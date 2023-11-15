package com.project.kraamzicht.repositories;

import com.project.kraamzicht.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}

