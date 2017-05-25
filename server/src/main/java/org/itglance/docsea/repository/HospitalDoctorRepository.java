package org.itglance.docsea.repository;


import org.itglance.docsea.domain.HospitalDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalDoctorRepository extends JpaRepository<HospitalDoctor,Long>{


    @Query("SELECT hd FROM HospitalDoctor  hd WHERE hd.hospital.id=:hospitalId AND hd.doctor.id=:doctorId ")
    public HospitalDoctor findByHospitalDoctor(@Param("hospitalId") Long hospitalId, @Param("doctorId") Long doctorId);

    @Query("SELECT h FROM HospitalDoctor h WHERE h.doctor.name=:searchString " +
            "OR h.doctor.speciality.name=:searchString " +
            "OR h.hospital.name=:searchString " +
            "OR h.hospital.address.streetAddress=:searchString " +
            "OR h.hospital.address.city.name=:searchString " +
            "OR h.hospital.address.district.name=:searchString " +
            "OR h.hospital.address.zone.name=:searchString " +
            "OR h.hospital.address.country.name=:searchString")
    public List<HospitalDoctor> findDoctorByString(@Param("searchString") String searchString);
}