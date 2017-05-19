package org.itglance.docsea.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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


    @ManyToOne
    private Speciality speciality;

    @OneToOne
    private Contact contact;

    @ManyToMany
    private List<Schedule> schedules=new ArrayList<>();

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


    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
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
                ", schedules=" + schedules +
                ", details='" + details + '\'' +
                '}';
    }

}




