package org.itglance.docsea.repository;


import org.itglance.docsea.service.dto.HospitalDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sanj__000 on 5/10/2017.
 */

public interface HospitalRepository extends JpaRepository<Hospital, Long>{
    public HospitalDTO findByRegistrationNo(String registrationNumber);
}
