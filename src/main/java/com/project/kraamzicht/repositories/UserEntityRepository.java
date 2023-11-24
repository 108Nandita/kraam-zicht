package com.project.kraamzicht.repositories;



import com.project.kraamzicht.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, String> {
}