package org.itglance.docsea.web.rest;

import org.itglance.docsea.service.StatusService;
import org.itglance.docsea.service.dto.HospitalDoctorDTO;
import org.itglance.docsea.service.dto.HospitalUserDTO;
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



    @PutMapping(value = "/toggleHospital/{userId}")
    public ResponseEntity<?> toggleHospitalStatus(@PathVariable("userId") Long userId){
        HospitalUserDTO hospitalUserDTO = statusService.toggleHospitalStatus(userId);
        return new ResponseEntity<HospitalUserDTO>(hospitalUserDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/toggleDoctor/{doctorId}")
    public ResponseEntity<?> toggleDoctorStatus(@RequestHeader String Authorization, @PathVariable("doctorId") Long docotorId){
        HospitalDoctorDTO hospitalDoctorDTO = statusService.toggleDoctorStatus(docotorId, Authorization);
        return new ResponseEntity<HospitalDoctorDTO>(hospitalDoctorDTO, HttpStatus.OK);
    }
}
