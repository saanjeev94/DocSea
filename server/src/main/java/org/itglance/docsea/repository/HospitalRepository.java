package org.itglance.docsea.repository;


import org.itglance.docsea.domain.Hospital;
import org.itglance.docsea.service.dto.HospitalDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by sanj__000 on 5/10/2017.
 */

public interface HospitalRepository extends JpaRepository<Hospital, Long>{
    public HospitalDTO findByRegistrationNo(String registrationNumber);

    @Query("SELECT h FROM Hospital h WHERE h.name = :hName OR h.registrationNo = :reg OR h.lisenceNo = :lisence")
    public HospitalDTO findByhospitalNameRegLisence(@Param("hName") String hName, @Param("reg") String reg, @Param("lisence") String lisence);

    public List<Hospital> findAllByName(String name);

   public List<Hospital> findAllByLisenceNo(String lisenceNo);

    public List<Hospital> findAllByRegistrationNo(String registrationNo);
}
