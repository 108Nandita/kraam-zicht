package com.project.kraamzicht.repositories;

import com.project.kraamzicht.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}

