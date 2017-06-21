package org.itglance.docsea.repository;

import org.itglance.docsea.domain.Doctor;
import org.itglance.docsea.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by sriyanka on 6/12/17.
 */
@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    public Event findById(Long id);

    @Query("SELECT e FROM Event e WHERE e.hospital.id=:id AND e.dates=:dates AND e.name=:name AND e.time=:time" )
    public Event isEventExist(@Param("id") Long id, @Param ("date") Date dates, @Param("name") String name, @Param("time") String time);

    @Query("SELECT e FROM Event  e WHERE e.dates >= :d")
   public List<Event> findAllValidEvent(@Param("d") Date d);

    @Query("SELECT e FROM Event  e WHERE e.dates >= :d AND e.hospital.id = :hospitalId")
    public List<Event> findAllValidEventsOfhospital(@Param("d") Date d, @Param("hospitalId") Long hospitalId);
}
