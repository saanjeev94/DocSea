package org.itglance.docsea.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanj__000 on 5/8/2017.
 */

@Entity
public class Hospital {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lisenceNo;
    private String registrationNo;

    @OneToOne
    private Contact contact;

    @OneToOne
    private Address address;

    @ManyToMany
    private List<Schedule> schedules=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLisenceNo() {
        return lisenceNo;
    }

    public void setLisenceNo(String lisenceNo) {
        this.lisenceNo = lisenceNo;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lisenceNo='" + lisenceNo + '\'' +
                ", registrationNo='" + registrationNo + '\'' +
                ", contact=" + contact +
                ", address=" + address +
                ", schedules=" + schedules +
                '}';
    }
}
