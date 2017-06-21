package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.Event;
import org.itglance.docsea.domain.Hospital;

import java.sql.Clob;
import java.util.Date;

/**
 * Created by sriyanka on 6/12/17.
 */
public class EventDTO {

    private Long id;
    private String name;
    private Hospital hospital;
    private Clob description;
    private Date date;
    private String time;
    private String photo;
    private String location;

    public EventDTO(){

    }

    public EventDTO(Long id, String name, Hospital hospital, Clob description, Date date, String time, String photo,String location) {
        this.id = id;
        this.name = name;
        this.hospital = hospital;
        this.description = description;
        this.date = date;
        this.time = time;
        this.photo = photo;
        this.location = location;
    }

    public EventDTO(Event event){
        this(event.getId(),event.getName(), event.getHospital(), event.getDescription(), event.getDates(), event.getTime(),event.getPhoto(), event.getLocation());
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

    public Clob getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public String getLocation() {
        return location;
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
                ", date=" + date +
                ", time='" + time + '\'' +
                ", photo='" + photo + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
