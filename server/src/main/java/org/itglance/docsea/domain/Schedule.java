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
    
    private Long dayId;

    public Long getId() {
        return id;
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

    public Long getDayId() {
        return dayId;
    }


}
