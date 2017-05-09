package org.itglance.docsea.service.dto;

/**
 * Created by sriyanka on 5/8/2017.
 */
public class Doctor {
    private Long id;
    private String name;
    private String qualification;
    private String photo;
    private Long specialityId;
    private Long contactId;
    private String details;

    public Doctor(){

    }

    public Doctor(Long id, String name, String qualification, String photo, String details) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.photo = photo;
        this.details = details;
    }

    public Doctor(Doctor doctor){
        this.id = doctor.id;
        this.name = doctor.name;
        this.qualification = doctor.qualification;
        this.photo = doctor.photo;
        this.details = doctor.details;

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
}

