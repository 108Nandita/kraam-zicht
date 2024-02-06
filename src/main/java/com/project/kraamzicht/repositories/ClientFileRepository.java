package com.project.kraamzicht.repositories;

import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.models.MaternityNurse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientFileRepository extends JpaRepository<ClientFile, Long> {
    List<ClientFile> findByMaternityNurse(MaternityNurse maternityNurse);
}

