package org.itglance.docsea.repository;

import org.itglance.docsea.domain.City;
import org.itglance.docsea.domain.District;
import org.itglance.docsea.service.dto.CityDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by sanj__000 on 5/12/2017.
 */
public interface CityRepository extends JpaRepository<City, Long> {
    public City findByName(String name);
    public List<City> findAllByDistrict(District district);

    public City findByDistrict(District district);

    @Query("SELECT c FROM City c WHERE c.district = :district AND c.name LIKE :city")
    City findByDistrictAndCityName(@Param("district") District district, @Param("city") String city);
}
