package org.itglance.docsea.repository;

import org.itglance.docsea.domain.User;
import org.itglance.docsea.service.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by soni on 5/8/2017.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);

    public List<User> findAllByUsername(String username);
}
