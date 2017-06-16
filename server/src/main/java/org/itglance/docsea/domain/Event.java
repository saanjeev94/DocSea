package org.itglance.docsea.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by sriyanka on 6/12/17.
 */

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @NotNull(message = "Event name cannot be null")
    private String name;

    @ManyToOne
    private Hospital hospital;
    private String description;

//    @NotNull(message = "Date cannot be null")
    private String date;

//    @NotNull(message = "Time cannot be null")
    private String time;
    private String photo;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Event{" +
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

