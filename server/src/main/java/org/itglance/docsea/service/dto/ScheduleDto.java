package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.Schedule;

import java.sql.Time;

/**
 * Created by sanj__000 on 5/8/2017.
 */
public class ScheduleDto {
    private Long id;
    private Time startTime;
    private Time endTime;
    private Long dayId;

    public ScheduleDto() {
    }

    public ScheduleDto(Schedule schedule) {
        this.id = schedule.getId();
        this.startTime = schedule.getStartTime();
        this.endTime = schedule.getEndTime();
        this.dayId = schedule.getDayId();
    }

    public ScheduleDto(Long id, Time startTime, Time endTime, Long dayId) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayId = dayId;
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

    public Long getDayId() {
        return dayId;
    }
}
