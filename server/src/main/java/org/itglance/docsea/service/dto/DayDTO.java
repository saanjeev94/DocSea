package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.Day;

/**
 * Created by sanj__000 on 5/8/2017.
 */
public class DayDTO {
    private Long id;
    private String day;

    public DayDTO() {
    }

    public DayDTO(Long id, String day) {
        this.id = id;
        this.day = day;
    }

    public DayDTO(Day day) {
        this(day.getId(), day.getDay());
    }

    public Long getId() {
        return id;
    }

    public String getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "DayDTO{" +
                "id=" + id +
                ", day='" + day + '\'' +
                '}';
    }
}


