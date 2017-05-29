package org.itglance.docsea.repository;

import org.itglance.docsea.domain.Country;
import org.itglance.docsea.domain.Zone;
import org.itglance.docsea.service.dto.ZoneDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by sanj__000 on 5/20/2017.
 */
public interface ZoneRepository extends JpaRepository<Zone, Long> {
    public List<Zone> findAllByCountry(Country country);
    public Zone findByName(String zone);

    @Query("SELECT z.name FROM Zone z WHERE z.name LIKE LOWER(CONCAT(:str, '%'))")
    public List<String> findThisDoctor(@Param("str") String str);
}
