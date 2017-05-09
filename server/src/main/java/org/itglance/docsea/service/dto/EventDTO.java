package org.itglance.docsea.service.dto;

/**
 * Created by Mahesh on 5/9/2017.
 */
public class EventDTO {
    private Long id;
    private String eventName;
    private Long hospital;
    private String description;
    private String date;
    private String time;
    private String photo;

    public Long getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public Long getHospital() {
        return hospital;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", hospital=" + hospital +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
