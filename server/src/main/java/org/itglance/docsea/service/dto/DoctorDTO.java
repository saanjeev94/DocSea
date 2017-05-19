package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.Doctor;

/**
 * Created by sriyanka on 5/8/2017.
 */
public class DoctorDTO {

    private Long id;
    private int nmcNumber;
    private String name;
    private String qualification;
    private String photo;
    private String gender;
    private Long speciality;
    private Long contact;
    private String details;

    public DoctorDTO(){

    }

    public DoctorDTO(Long id, int nmcNumber, String name, String qualification, String photo, String gender, Long speciality, Long contact, String details) {
        this.id = id;
        this.nmcNumber = nmcNumber;
        this.name = name;
        this.qualification = qualification;
        this.photo = photo;
        this.gender = gender;
        this.speciality = speciality;
        this.contact = contact;
        this.details = details;
    }



    public DoctorDTO(Doctor doctor){
        this(doctor.getId(),doctor.getNmcNumber(),doctor.getName(),doctor.getQualification(),doctor.getPhoto(),doctor.getGender(),doctor.getSpeciality(),doctor.getContact(),doctor.getDetails());

    }

    public Long getId() {
        return id;
    }

    public int getNmcNumber(){ return nmcNumber;}

    public String getName() { return name;}

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "id=" + id +
                ", nmcNumber=" + nmcNumber +
                ", name='" + name + '\'' +
                ", qualification='" + qualification + '\'' +
                ", photo='" + photo + '\'' +
                ", gender='" + gender + '\'' +
                ", speciality=" + speciality +
                ", contact=" + contact +
                ", details='" + details + '\'' +
                '}';
    }

}

