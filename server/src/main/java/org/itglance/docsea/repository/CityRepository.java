package org.itglance.docsea.repository;

import org.itglance.docsea.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sanj__000 on 5/12/2017.
 */
public interface CityRepository extends JpaRepository<City, Long> {
    public City findByName(String name);
}
