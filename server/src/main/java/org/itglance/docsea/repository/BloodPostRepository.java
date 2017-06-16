package org.itglance.docsea.repository;

import org.itglance.docsea.domain.BloodPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by sanjib on 6/12/17.
 */
public interface BloodPostRepository extends JpaRepository <BloodPost,Long>{


    @Query(value = "SELECT b FROM BloodPost b WHERE b.deadline >= :date",
            countQuery = "SELECT count(b)FROM BloodPost b WHERE b.deadline >= :date")
    Page<BloodPost> findValideBlood( @Param("date") Date date, Pageable page );

    public BloodPost findByBloodGroup(String group);
}
