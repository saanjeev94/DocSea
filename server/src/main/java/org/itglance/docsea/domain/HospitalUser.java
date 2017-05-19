package org.itglance.docsea.domain;

import javax.persistence.*;

/**
 * Created by soni on 5/10/2017.
 */
@Entity
public class HospitalUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Hospital hospitall;

    @OneToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hospital getHospitall() {
        return hospitall;
    }

    public void setHospitall(Hospital hospitall) {
        this.hospitall = hospitall;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
