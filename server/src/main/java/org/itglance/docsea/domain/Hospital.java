package org.itglance.docsea.domain;

import javax.persistence.*;

/**
 * Created by sanj__000 on 5/8/2017.
 */

@Entity
public class Hospital {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    //@OneToOne
    private String lisenceNo;

    //@OneToOne
    private String registrationNo;
    private Long contact;
    private Long address;

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

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
        this.address = address;
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
                '}';
    }
}
