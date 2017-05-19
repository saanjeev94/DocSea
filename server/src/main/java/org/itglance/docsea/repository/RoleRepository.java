package org.itglance.docsea.repository;

import org.itglance.docsea.domain.Role;
import org.itglance.docsea.service.dto.RoleDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by soni on 5/8/2017.
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    public Role findByRole(String roleStr);
}
