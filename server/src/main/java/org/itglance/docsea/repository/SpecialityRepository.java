package org.itglance.docsea.repository;

import org.itglance.docsea.domain.Speciality;
import org.itglance.docsea.service.dto.SpecialityDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

//    @Query("SELECT s FROM Speciality s WHERE s.name = :sName")
//    public Speciality findByName(@Param("sName") String sName);

    public Speciality findByName(String speciality);
}