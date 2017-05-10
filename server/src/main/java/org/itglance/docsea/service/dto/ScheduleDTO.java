package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.Day;
import org.itglance.docsea.domain.Schedule;

import java.sql.Time;

/**
 * Created by sanj__000 on 5/8/2017.
 */

public class ScheduleDTO {
    private Long id;
    private Time startTime;
    private Time endTime;
    private Day day;

    public ScheduleDTO() {
    }

    public ScheduleDTO(Schedule schedule) {
        this(schedule.getId(), schedule.getStartTime(), schedule.getEndTime(),schedule.getDay());
    }

    public ScheduleDTO(Long id, Time startTime, Time endTime, Day day) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
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

    public Day getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "ScheduleDTO{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", day=" + day +
                '}';
    }
}
