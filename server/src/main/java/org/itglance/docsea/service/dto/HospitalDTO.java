package org.itglance.docsea.service.dto;

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
    private Long contactId;
    private Long addressId;

    public HospitalDTO() {
    }



    public HospitalDTO(Long id, String name, String lisenceNo, String registrationNo, Long contactId, Long addressId) {
        this.id = id;
        this.name = name;
        this.lisenceNo = lisenceNo;
        this.registrationNo = registrationNo;
        this.contactId = contactId;
        this.addressId = addressId;
    }

    public HospitalDTO(Hospital hospital) {
        this(hospital.getId(), hospital.getName(), hospital.getLisenceNo(), hospital.getRegistrationNo(), hospital.getContactId(), hospital.getAddressId());
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

    public Long getContactId() {
        return contactId;
    }

    public Long getAddressId() {
        return addressId;
    }

    @Override
    public String toString() {
        return "HospitalDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lisenceNo='" + lisenceNo + '\'' +
                ", registrationNo='" + registrationNo + '\'' +
                ", contactId=" + contactId +
                ", addressId=" + addressId +
                '}';
    }
}
