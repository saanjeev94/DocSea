package org.itglance.docsea.repository;

import org.itglance.docsea.domain.Schedule;
import org.itglance.docsea.service.dto.ScheduleDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long>{



}