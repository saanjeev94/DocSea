package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.Address;
import org.itglance.docsea.domain.Contact;
import org.itglance.docsea.domain.Hospital;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by sanj__000 on 5/8/2017.
 */
public class HospitalDTO {
    private Long id;
    private String name;
    private String lisenceNo;
    private String registrationNo;
    private Contact contact;
    private Address address;

    public HospitalDTO() {
    }

    public HospitalDTO(Long id, String name, String lisenceNo, String registrationNo, Contact contact, Address address) {
        this.id = id;
        this.name = name;
        this.lisenceNo = lisenceNo;
        this.registrationNo = registrationNo;
        this.contact = contact;
        this.address = address;
    }

    public HospitalDTO(Hospital hospital) {
        this(hospital.getId(), hospital.getName(), hospital.getLisenceNo(), hospital.getRegistrationNo(), hospital.getContact(), hospital.getAddress());
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLisenceNo() {
        return lisenceNo;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "HospitalDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lisenceNo='" + lisenceNo + '\'' +
                ", registrationNo='" + registrationNo + '\'' +
                ", contact=" + contact +
                ", address=" + address +
                '}';
    }
}
