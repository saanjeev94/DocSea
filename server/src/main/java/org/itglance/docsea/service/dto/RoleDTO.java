package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.Role;

/**
 * Created by soni on 5/8/2017.
 */
public class RoleDTO {

    private Long id;
    private String role;

    public RoleDTO() {
    }

    public RoleDTO(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public RoleDTO(Role role){
        this(role.getId(),role.getRole());
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
