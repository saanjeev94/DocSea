package org.itglance.docsea.repository;

import org.itglance.docsea.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by soni on 5/8/2017.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
