package org.itglance.docsea.repository;

import org.itglance.docsea.domain.Doctor;
import org.itglance.docsea.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long>{
    public Doctor findByNmcNumber(int nmcNumber);

    public List<Doctor> findAllByNmcNumber(int nmcNumber);

    public Doctor findById(Long id);

    @Query("SELECT d.schedules FROM Doctor d WHERE d.id=:doctorId ")
    public List<Schedule> findScheduleByDoctorId(@Param("doctorId") Long doctorId);




}