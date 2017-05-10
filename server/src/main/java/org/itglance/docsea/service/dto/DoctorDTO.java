package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.Contact;
import org.itglance.docsea.domain.Doctor;
import org.itglance.docsea.domain.Speciality;

/**
 * Created by sriyanka on 5/8/2017.
 */
public class DoctorDTO {
    private Long id;
    private String name;
    private String qualification;
    private String photo;
    private Speciality speciality;
    private Contact contact;
    private String details;

    public DoctorDTO(){

    }

    public DoctorDTO(Long id, String name, String qualification, String photo, Speciality speciality, Contact contact, String details) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.photo = photo;
        this.speciality = speciality;
        this.contact = contact;
        this.details = details;
    }

    public DoctorDTO(Doctor doctor){
        this(doctor.getId(),doctor.getName(),doctor.getQualification(),doctor.getPhoto(),doctor.getSpeciality(),doctor.getContact(),doctor.getDetails());

    }

    public Long getId() {
        return id;
    }

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

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qualification='" + qualification + '\'' +
                ", photo='" + photo + '\'' +
                ", specialityId=" + speciality +
                ", contactId=" + contact +
                ", details='" + details + '\'' +
                '}';
    }
}

