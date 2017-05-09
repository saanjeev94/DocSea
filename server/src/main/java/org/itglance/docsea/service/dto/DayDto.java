package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.Day;

/**
 * Created by sanj__000 on 5/8/2017.
 */
public class DayDto {
    private Long id;
    private String day;

    public DayDto() {
    }

    public DayDto(Long id, String day) {
        this.id = id;
        this.day = day;
    }

    public DayDto(Day day) {
        this.id = day.getId();
        this.day = day.getDay();
    }



    public Long getId() {
        return id;
    }

    public String getDay() {
        return day;
    }
}
