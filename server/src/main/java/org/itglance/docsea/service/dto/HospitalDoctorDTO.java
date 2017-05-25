package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.Doctor;
import org.itglance.docsea.domain.Hospital;
import org.itglance.docsea.domain.HospitalDoctor;
import org.itglance.docsea.domain.Status;

/**
 * Created by sriyanka on 5/25/2017.
 */
public class HospitalDoctorDTO {

    private int id;
    private Hospital hospital;
    private Doctor doctor;
    private Status status;

    public HospitalDoctorDTO(){

    }

    public HospitalDoctorDTO(int id, Hospital hospital, Doctor doctor, Status status) {
        this.id = id;
        this.hospital = hospital;
        this.doctor = doctor;
        this.status = status;
    }

    public HospitalDoctorDTO(HospitalDoctor hospitalDoctor){
        this(hospitalDoctor.getId(),hospitalDoctor.getHospital(),hospitalDoctor.getDoctor(),hospitalDoctor.getStatus());
    }

    public int getId() {
        return id;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "HospitalDoctorDTO{" +
                "id=" + id +
                ", hospital=" + hospital +
                ", doctor=" + doctor +
                ", status=" + status +
                '}';
    }
}
