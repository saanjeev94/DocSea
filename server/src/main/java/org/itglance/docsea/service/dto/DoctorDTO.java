package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.Doctor;

/**
 * Created by sriyanka on 5/8/2017.
 */
public class DoctorDTO {
    private Long id;
    private String name;
    private String qualification;
    private String photo;
    private Long specialityId;
    private Long contactId;
    private String details;

    public DoctorDTO(){

    }

    public DoctorDTO(Long id, String name, String qualification, String photo, Long specialityId, Long contactId, String details) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.photo = photo;
        this.specialityId = specialityId;
        this.contactId = contactId;
        this.details = details;
    }

    public DoctorDTO(Doctor doctor){
        this(doctor.getId(),doctor.getName(),doctor.getQualification(),doctor.getPhoto(),doctor.getSpecialityId(),doctor.getContactId(),doctor.getDetails());

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

    public Long getSpecialityId() {
        return specialityId;
    }

    public Long getContactId() {
        return contactId;
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
                ", specialityId=" + specialityId +
                ", contactId=" + contactId +
                ", details='" + details + '\'' +
                '}';
    }
}

