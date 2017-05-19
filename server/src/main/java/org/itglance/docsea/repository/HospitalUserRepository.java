package org.itglance.docsea.repository;

import org.itglance.docsea.domain.HospitalUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sanj__000 on 5/11/2017.
 */
public interface HospitalUserRepository extends JpaRepository<HospitalUser,Long> {
}
