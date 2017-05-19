package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.Hospital;
import org.itglance.docsea.domain.HospitalUser;
import org.itglance.docsea.domain.User;

/**
 * Created by sanj__000 on 5/13/2017.
 */
public class HospitalUserDTO {

    private Long id;
    private Hospital hospitall;
    private User user;

    public HospitalUserDTO() {
    }

    public HospitalUserDTO(Long id, Hospital hospitall, User user) {
        this.id = id;
        this.hospitall = hospitall;
        this.user = user;
    }

    public HospitalUserDTO(HospitalUser hospitalUser) {
        this.id = hospitalUser.getId();
        this.hospitall = hospitalUser.getHospitall();
        this.user = hospitalUser.getUser();
    }

    public Long getId() {
        return id;
    }

    public Hospital getHospitall() {
        return hospitall;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "HospitalUserDTO{" +
                "id=" + id +
                ", hospitall=" + hospitall +
                ", user=" + user +
                '}';
    }
}
