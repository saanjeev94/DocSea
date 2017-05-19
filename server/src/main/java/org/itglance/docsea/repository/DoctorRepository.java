package org.itglance.docsea.repository;

import org.itglance.docsea.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long>{

}