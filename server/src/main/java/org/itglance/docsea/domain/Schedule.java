package org.itglance.docsea.domain;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by sanj__000 on 5/8/2017.
 */

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Time startTime;
    private Time endTime;
    
    private Long day;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Long getDay() {
        return day;
    }

    public void setDay(Long day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", day=" + day +
                '}';
    }
}
