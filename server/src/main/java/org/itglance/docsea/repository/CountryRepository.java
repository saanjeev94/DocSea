package org.itglance.docsea.repository;

import org.itglance.docsea.domain.Country;
import org.itglance.docsea.service.dto.CountryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by sanj__000 on 5/20/2017.
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
    public Country findByName(String country);

    @Query("SELECT c.name FROM Country c WHERE c.name LIKE LOWER(CONCAT(:str, '%'))")
    public List<String> findThisDoctor(@Param("str") String str);
}
