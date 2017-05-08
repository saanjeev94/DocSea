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
    private Long speciaityId;

    @OneToOne
    private Long contactId;
    private String details;


    public Doctor(){

    }
    public Doctor(String name, String qualification, String photo, String details) {
        this.name = name;
        this.qualification = qualification;
        this.photo = photo;
        this.details = details;
    }

    public Long getId() {
        return id;
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

    public Long getSpeciaityId() {
        return speciaityId;
    }

    public void setSpeciaityId(Long speciaityId) {
        this.speciaityId = speciaityId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
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
                ", speciaityId=" + speciaityId +
                ", contactId=" + contactId +
                ", details='" + details + '\'' +
                '}';
    }
}
