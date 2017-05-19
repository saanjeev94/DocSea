package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.Contact;
import org.itglance.docsea.domain.Doctor;
import org.itglance.docsea.domain.Speciality;

/**
 * Created by sriyanka on 5/8/2017.
 */
public class DoctorDTO {

    private Long id;
    private int nmcNumber;
    private String name;
    private String qualification;
    private String photo;
<<<<<<< HEAD
    private String gender;
    private Long speciality;
    private Long contact;
=======
    private Speciality speciality;
    private Contact contact;
>>>>>>> frontBackHospital
    private String details;

    public DoctorDTO(){

    }

<<<<<<< HEAD
    public DoctorDTO(Long id, int nmcNumber, String name, String qualification, String photo, String gender, Long speciality, Long contact, String details) {
=======
    public DoctorDTO(Long id, String name, String qualification, String photo, Speciality speciality, Contact contact, String details) {
>>>>>>> frontBackHospital
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

<<<<<<< HEAD
    public int getNmcNumber(){ return nmcNumber;}

    public String getName() { return name;}
=======
    public String getName() {
        return name;
    }

    public String getQualification() {
        return qualification;
    }

    public String getPhoto() {
        return photo;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public Contact getContact() {
        return contact;
    }

    public String getDetails() {
        return details;
    }
>>>>>>> frontBackHospital

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

