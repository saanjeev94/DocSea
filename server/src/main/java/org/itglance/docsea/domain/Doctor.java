package org.itglance.docsea.domain;


import javax.persistence.*;

/**
 * Created by sriyanka on 5/8/2017.
 */

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private int nmcNumber;
    private String name;
    private String qualification;
    private String photo;
    private String gender;

    // @ManyToOne
    private Long speciality;

    //@OneToOne
    private Long contact;
    private String details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNmcNumber() {
        return nmcNumber;
    }

    public void setNmcNumber(int nmcNumber) {
        this.nmcNumber = nmcNumber;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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




