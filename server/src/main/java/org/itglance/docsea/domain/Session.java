package org.itglance.docsea.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by soni on 5/23/2017.
 */
@Entity
public class Session {
    @Id
    private String token;
    private Long hospitalId;
    private Long userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }



    @Override
    public String toString() {
        return "Session{" +
                "token='" + token + '\'' +
                ", hospitalId=" + hospitalId +
                ", userId=" + userId +
                '}';
    }

    public String toStringForToken() {
        return token+"."+hospitalId+"."+userId;
    }
}
