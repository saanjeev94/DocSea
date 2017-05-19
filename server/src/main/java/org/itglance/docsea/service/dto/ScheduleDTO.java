package org.itglance.docsea.service.dto;

<<<<<<< HEAD
import org.itglance.docsea.domain.Days;
=======
import org.itglance.docsea.domain.Day;
>>>>>>> frontBackHospital
import org.itglance.docsea.domain.Schedule;

import java.sql.Time;

/**
 * Created by sanj__000 on 5/8/2017.
 */

public class ScheduleDTO {
    private Long id;
    private Time startTime;
    private Time endTime;
<<<<<<< HEAD
    private Days days;
=======
    private Day day;
>>>>>>> frontBackHospital

    public ScheduleDTO() {
    }

    public ScheduleDTO(Schedule schedule) {
        this(schedule.getId(), schedule.getStartTime(), schedule.getEndTime(),schedule.getDays());
    }

<<<<<<< HEAD
    public ScheduleDTO(Long id, Time startTime, Time endTime, Days days) {
=======
    public ScheduleDTO(Long id, Time startTime, Time endTime, Day day) {
>>>>>>> frontBackHospital
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.days = days;
    }

    public Long getId() {
        return id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

<<<<<<< HEAD
    public Days getDays() {
        return days;
=======
    public Day getDay() {
        return day;
>>>>>>> frontBackHospital
    }

    @Override
    public String toString() {
        return "ScheduleDTO{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", days=" + days +
                '}';
    }
}
