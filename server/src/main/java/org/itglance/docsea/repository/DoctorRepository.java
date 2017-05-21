package org.itglance.docsea.repository;

import org.itglance.docsea.domain.Doctor;
import org.itglance.docsea.service.dto.DoctorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long>{
    public Doctor findByNmcNumber(int nmcNumber);

    //public DoctorDTO findByNmcNumber(int nmcNumber);



    public DoctorDTO findById(Long id);



}