package org.itglance.docsea.service;

import org.itglance.docsea.domain.HospitalUser;
import org.itglance.docsea.domain.Session;
import org.itglance.docsea.domain.User;
import org.itglance.docsea.repository.HospitalUserRepository;
import org.itglance.docsea.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;

/**
 * Created by soni on 5/8/2017.
 */
@Service
@Transactional
public class UserService {


    @Autowired
    SessionService sessionService;

    private final HospitalUserRepository hospitalUserRepository;
    private final UserRepository userRepository;

    public UserService(HospitalUserRepository hospitalUserRepository, UserRepository userRepository) {
        this.hospitalUserRepository = hospitalUserRepository;
        this.userRepository = userRepository;
    }

    public String validateLogin(User user){
        User dbUser = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if(dbUser != null){
            HospitalUser hospitalUser =hospitalUserRepository.findByUser(dbUser);
            Session session = sessionService.createSession(hospitalUser);
            String mainToken =  session.toStringForToken();
            byte[] encode = Base64.getEncoder().encode(mainToken.getBytes());
            return new String(encode);
        }
        return null;
    }

}
