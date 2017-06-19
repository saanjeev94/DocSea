package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.Event;
import org.itglance.docsea.domain.Hospital;

/**
 * Created by sriyanka on 6/12/17.
 */
public class EventDTO {

    private Long id;
    private String name;
    private Hospital hospital;
    private String description;
    private String date;
    private String time;
    private String photo;

    public EventDTO(){

    }

    public EventDTO(Long id, String name, Hospital hospital, String description, String date, String time, String photo) {
        this.id = id;
        this.name = name;
        this.hospital = hospital;
        this.description = description;
        this.date = date;
        this.time = time;
        this.photo = photo;
    }

    public EventDTO(Event event){
        this(event.getId(),event.getName(), event.getHospital(), event.getDescription(), event.getDate(), event.getTime(),event.getPhoto());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Hospital getHospital() {
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
                ", name='" + name + '\'' +
                ", hospital=" + hospital +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
