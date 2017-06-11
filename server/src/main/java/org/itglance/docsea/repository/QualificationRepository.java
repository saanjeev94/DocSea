package org.itglance.docsea.repository;

import org.itglance.docsea.domain.Qualification;
import org.itglance.docsea.domain.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by soni on 5/30/2017.
 */
public interface QualificationRepository extends JpaRepository<Qualification,Long> {
    public Qualification findByName(String qualification);
}
