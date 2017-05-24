package org.itglance.docsea.repository;


import org.itglance.docsea.domain.HospitalDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalDoctorRepository extends JpaRepository<HospitalDoctor,Long>{


    @Query("SELECT hd FROM HospitalDoctor  hd WHERE hd.hospital.id=:hospitalId AND hd.doctor.id=:doctorId ")
    public HospitalDoctor findByHospitalDoctor(@Param("hospitalId") Long hospitalId, @Param("doctorId") Long doctorId);


}