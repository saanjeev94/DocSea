package org.itglance.docsea.domain;

import javax.persistence.*;

/**
 * Created by sriyanka on 5/8/2017.
 */

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String qualification;
    private String photo;

    @ManyToOne
    private Long speciality;

    @OneToOne
    private Long contact;
    private String details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Long speciality) {
        this.speciality = speciality;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qualification='" + qualification + '\'' +
                ", photo='" + photo + '\'' +
                ", speciality=" + speciality +
                ", contact=" + contact +
                ", details='" + details + '\'' +
                '}';
    }
}
