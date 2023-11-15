package com.project.kraamzicht.repositories;


import com.project.kraamzicht.models.ClientFile;
import com.project.kraamzicht.models.Indication;
import com.project.kraamzicht.models.Midwife;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IndicationRepository extends JpaRepository<Indication, Long> {
    List<Indication> findByClientFile(ClientFile clientFile);
    List<Indication> findByMidwife(Midwife midwife);
}
