package com.project.kraamzicht.repositories;

import com.project.kraamzicht.dtos.ContactDetailsDto;
import com.project.kraamzicht.dtos.UserDetailsDto;
import com.project.kraamzicht.models.MaternityNurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaternityNurseRepository extends JpaRepository<MaternityNurse, String> {
    @Query("SELECT a FROM MaternityNurse a WHERE a.username = :username")
    MaternityNurse findMaternityNurseByUsername(@Param("username") String username);

    @Query("UPDATE MaternityNurse a SET a.name = :#{#userDetailsDto.name}, a.surname = :#{#userDetailsDto.surname}, a.dob = :#{#userDetailsDto.dob}, a.address = :#{#userDetailsDto.address}, a.postalcode = :#{#userDetailsDto.postalcode}, a.place = :#{#userDetailsDto.place} WHERE a.username = :username")
    @Modifying
    void updateUserDetails(@Param("username") String username, @Param("userDetailsDto") UserDetailsDto userDetailsDto);

    @Query("UPDATE Admin a SET a.phoneNr = :#{#contactDetailsDto.phoneNr}, a.email = :#{#contactDetailsDto.email} WHERE a.username = :username")
    @Modifying
    void updateContactDetails(@Param("username") String username, @Param("contactDetailsDto") ContactDetailsDto contactDetailsDto);

    @Modifying
    @Query("DELETE FROM Admin a WHERE a.username = :username")
    void deleteMaternityNurseByUsername(@Param("username") String username);

}
