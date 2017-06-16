package org.itglance.docsea.domain;

import org.jboss.logging.Field;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by soni on 5/9/2017.
 */
@Entity
public class HospitalDoctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne
    private Hospital hospital;

    @ManyToOne
    private Doctor doctor;

    @OneToOne
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HospitalDoctor{" +
                "id=" + id +
                ", hospital=" + hospital +
                ", doctor=" + doctor +
                ", status=" + status +
                '}';
    }
}
