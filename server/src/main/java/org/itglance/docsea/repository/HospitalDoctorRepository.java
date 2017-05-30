package org.itglance.docsea.repository;


import org.itglance.docsea.domain.Doctor;
import org.itglance.docsea.domain.Hospital;
import org.itglance.docsea.domain.HospitalDoctor;
import org.itglance.docsea.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalDoctorRepository extends JpaRepository<HospitalDoctor,Long>{

    @Query("SELECT hd FROM HospitalDoctor  hd WHERE hd.hospital.id=:hospitalId AND hd.doctor.id=:doctorId ")
    public HospitalDoctor findByHospitalDoctor(@Param("hospitalId") Long hospitalId, @Param("doctorId") Long doctorId);

//    Search Doctor
    @Query("SELECT h FROM HospitalDoctor h WHERE " +
            " h.doctor.name LIKE LOWER(:searchString) " +
            "OR h.doctor.speciality.name  LIKE LOWER(:searchString) " +
            "OR h.hospital.name  LIKE LOWER(:searchString) " +
            "OR h.hospital.address.streetAddress  LIKE LOWER (:searchString)" +
            "OR h.hospital.address.city.name  LIKE LOWER(:searchString) "+
            "OR h.hospital.address.district.name  LIKE LOWER(:searchString) " +
            "OR h.hospital.address.zone.name  LIKE LOWER(:searchString) " +
            "OR h.hospital.address.country.name  LIKE LOWER(:searchString)"
            )
    public List<HospitalDoctor> findDoctorByString(@Param("searchString") String searchString);





    @Query("SELECT  hd FROM HospitalDoctor hd WHERE hd.doctor = :doctor AND hd.hospital = :hospital")
    public HospitalDoctor findByHospitalAndDoctor(Hospital hospital, Doctor doctor);


    @Query("SELECT hd.doctor FROM HospitalDoctor hd WHERE hd.hospital = :hospital AND hd.status NOT LIKE:status")
   public List<Doctor> findAllByHospital(@Param("hospital") Hospital hospital, @Param("status") Status status);


    @Query("SELECT hd.status FROM HospitalDoctor hd WHERE hd.hospital = :hospital AND hd.doctor = :doctor")
    public Status findStatusByHospitalDoctor(@Param("hospital") Hospital hospital,@Param("doctor") Doctor doctor);
}