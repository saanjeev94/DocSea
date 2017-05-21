package org.itglance.docsea.repository;

import org.itglance.docsea.domain.District;
import org.itglance.docsea.service.dto.DistrictDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sanj__000 on 5/20/2017.
 */
public interface DistrictRepository extends JpaRepository<District, Long> {
    public List<DistrictDTO> findAllByZone(String zone);
    public District findAllByName(String district);
}