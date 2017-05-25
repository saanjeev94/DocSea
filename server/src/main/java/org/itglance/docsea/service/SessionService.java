package org.itglance.docsea.service;

import org.itglance.docsea.domain.HospitalUser;
import org.itglance.docsea.domain.Session;
import org.itglance.docsea.repository.HospitalRepository;
import org.itglance.docsea.repository.SessionRepository;
import org.itglance.docsea.repository.StatusRepository;
import org.itglance.docsea.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sanj__000 on 5/23/2017.
 */

@Service
@Transactional
public class SessionService {
    public static Map<String, Session> sessions = new ConcurrentHashMap<>();
    private final SessionRepository sessionRepository;
    private final HospitalRepository hospitalRepository;
    private final UserRepository userRepository;
    private final StatusRepository statusRepository;

    public SessionService(SessionRepository sessionRepository, HospitalRepository hospitalRepository, UserRepository userRepository, StatusRepository statusRepository) {
        this.sessionRepository = sessionRepository;
        this.hospitalRepository = hospitalRepository;
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
    }


    public boolean checkSession(String authenticate) {
        //TODO DO Base64 Decode
        byte[] decodedBytes = Base64.getDecoder().decode(authenticate.getBytes());
        String str = new String(decodedBytes);
        System.out.println("Token = "+str);
        String[]  array = str.split("\\.");
        System.out.println("After spliting token:");
        for(String s : array){
            System.out.println(s);
        }

        String token = null;
        Long hospitalId = null;
        Long userId = null;
        try {
           token = array[0];
           hospitalId = Long.valueOf(array[1]);
           userId = Long.valueOf(array[2]);
        }catch(Exception e)
        {
            System.out.println("This exception came from arrey ignore it");
        }
        if(sessions.containsKey(token))
        {
           return true;
        }else{
            Session  session = sessionRepository.findByToken(token);
            if(session != null){
                sessions.put(token, session);
                return true;
            }
        }
        return false;
    }

    public Session createSession(HospitalUser hospitalUser){
        String token = UUID.randomUUID().toString();
        Session session = new Session();
        session.setToken(token);
        session.setHospitalId(hospitalUser.getHospital().getId());
        session.setUserId(hospitalUser.getUser().getId());
        sessions.put(token, session);
        sessionRepository.save(session);

        return session;
    }

    public void removeSession(String authenticate){
        byte[] decodedBytes = Base64.getDecoder().decode(authenticate.getBytes());
        String str = new String(decodedBytes);
        String[] array = str.split("-");
        String token = array[0];
        Session session = sessionRepository.findByToken(token);
        if(sessions.containsKey(token) || session != null){
            sessions.remove(token);
            sessionRepository.delete(session);
            System.out.println("Session deleted sucessfull !!!!");
        }
    }

}
