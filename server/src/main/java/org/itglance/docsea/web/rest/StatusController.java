package org.itglance.docsea.web.rest;

import org.itglance.docsea.domain.*;
import org.itglance.docsea.repository.*;
import org.itglance.docsea.service.SessionService;
import org.itglance.docsea.service.StatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by soni on 5/8/2017.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/api/status")
public class StatusController {

    private final Logger log = LoggerFactory.getLogger(StatusService.class);
    @Autowired
    StatusService statusService;
    @Autowired
    SessionService sessionService;
    private final UserRepository userRepository;
    private final StatusRepository statusRepository;
    private final HospitalRepository hospitalRepository;
    private final HospitalDoctorRepository hospitalDoctorRepository;
    private final DoctorRepository doctorRepository;
    private final HospitalUserRepository hospitalUserRepository;

    public StatusController(UserRepository userRepository, StatusRepository statusRepository, HospitalRepository hospitalRepository
                            , HospitalDoctorRepository hospitalDoctorRepository, DoctorRepository doctorRepository
                            , HospitalUserRepository hospitalUserRepository) {
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
        this.hospitalRepository = hospitalRepository;
        this.hospitalDoctorRepository = hospitalDoctorRepository;
        this.doctorRepository = doctorRepository;
        this.hospitalUserRepository = hospitalUserRepository;
    }

    @PutMapping(value = "/toggleHospital/{userId}")
    public ResponseEntity<?> toggleHospitalStatus(@PathVariable("userId") Long userId){
        HospitalUser hospitalUser = hospitalUserRepository.findOne(userId);

        User user = userRepository.findOne(hospitalUser.getUser().getId());
        Status status = new Status();
        if(user.getStatus().getStatus().equalsIgnoreCase("ACTIVE"))
        {
            status = statusService.getStatusObject("INACTIVE");
            System.out.println("Username "+user.getUsername()+" updated to INACTIVE");
        }else if(user.getStatus().getStatus().equalsIgnoreCase("INACTIVE")){
            status = statusService.getStatusObject("ACTIVE");
            System.out.println("Username "+user.getUsername()+" updated to ACTIVE");
        }else{
            status = statusService.getStatusObject("DEACTIVE");
            System.out.println("Username "+user.getUsername()+" user is DEACTIVE");
        }
        user.setStatus(status);
        userRepository.save(user);
        HospitalUser hospitalUser1 = hospitalUserRepository.findOne(userId);
        return new ResponseEntity<HospitalUser>(hospitalUser1, HttpStatus.OK);
    }

    @PutMapping(value = "/toggleDoctor/{doctorId}")
    public ResponseEntity<?> toggleDoctorStatus(@RequestHeader String Authorization, @PathVariable("doctorId") Long docotorId){
        Session session = sessionService.checkSession(Authorization);
        Long hospitalId = session.getHospitalId();
        Hospital hospital = hospitalRepository.findOne(hospitalId);
        Doctor doctor = doctorRepository.findOne(docotorId);
        HospitalDoctor hospitalDoctor = hospitalDoctorRepository.findByHospitalAndDoctor(hospital, doctor);
        Status status = new Status();
       if(hospitalDoctor.getStatus().getStatus().equalsIgnoreCase("ACTIVE"))
        {
            status = statusService.getStatusObject("INACTIVE");
            System.out.println("Doctor status whose name is "+doctor.getName()+", updated to INACTIVE");
        }else if(hospitalDoctor.getStatus().getStatus().equalsIgnoreCase("INACTIVE")){
            status = statusService.getStatusObject("ACTIVE");
            System.out.println("Doctor status whose name is "+doctor.getName()+",updated to ACTIVE");
        }else{
            status = statusService.getStatusObject("DEACTIVE");
            System.out.println("Doctor whose name is "+doctor.getName()+" is deactivated");
        }
        hospitalDoctor.setStatus(status);
        hospitalDoctorRepository.save(hospitalDoctor);
        return new ResponseEntity<HospitalDoctor>(hospitalDoctor, HttpStatus.OK);
    }
}
