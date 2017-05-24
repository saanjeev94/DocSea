package org.itglance.docsea.repository;

import org.itglance.docsea.domain.Schedule;
<<<<<<< HEAD
import org.itglance.docsea.service.dto.ScheduleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
=======
import org.itglance.docsea.domain.Days;
import org.itglance.docsea.service.dto.ScheduleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.List;
>>>>>>> origin/scheduleBackendRevised

public interface ScheduleRepository extends JpaRepository<Schedule,Long>{


<<<<<<< HEAD

=======
    @Query("select s from Schedule s where s.startTime like :startTime AND s.endTime like :endTime AND s.days.id=:days")
    public Schedule findByStartEndTime(@Param("startTime") Time startTime, @Param("endTime") Time endTime, @Param("days") Long days );

    public Schedule findById(Long id);
>>>>>>> origin/scheduleBackendRevised
}