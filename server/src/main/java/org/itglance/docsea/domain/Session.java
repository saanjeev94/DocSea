package org.itglance.docsea.domain;

/**
 * Created by soni on 5/23/2017.
 */
public class Session {
    private String token;
    private String userId;
    private Integer userType;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
