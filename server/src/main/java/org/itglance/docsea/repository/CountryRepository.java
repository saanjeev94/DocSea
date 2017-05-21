package org.itglance.docsea.repository;

import org.itglance.docsea.domain.Country;
import org.itglance.docsea.service.dto.CountryDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sanj__000 on 5/20/2017.
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
    public Country findByName(String country);
}
