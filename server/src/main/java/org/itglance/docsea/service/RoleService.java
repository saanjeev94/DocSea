package org.itglance.docsea.service;

import org.itglance.docsea.domain.Role;
import org.itglance.docsea.repository.RoleRepository;
import org.itglance.docsea.service.dto.RoleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sanj__000 on 5/11/2017.
 */
@Service
@Transactional
public class RoleService {

    private final Logger log = LoggerFactory.getLogger(RoleService.class);
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addRole(String roleStr){
        Role role = new Role();
        role.setRole(roleStr);
        roleRepository.save(role);
        log.info("New Role "+roleStr+" has been inserted into Role table");

    }

    public Role getRoleObject(String roleStr)
    {
        Role role = new Role();
        List<Role> roleList = roleRepository.findAll();
        if(!roleList.isEmpty()){
            for(Role r : roleList){
                if(r.getRole().equalsIgnoreCase(roleStr)){
                    return r;
                }
            }
        }
        addRole(roleStr);
        role = roleRepository.findByRole(roleStr);
        return role;
    }
}
