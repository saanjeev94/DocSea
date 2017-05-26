package org.itglance.docsea.web.rest;

import org.itglance.docsea.domain.Schedule;
import org.itglance.docsea.domain.Status;
import org.itglance.docsea.service.HospitalDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sriyanka on 5/23/2017.
 */

@RestController
@RequestMapping(value = "/api/hospitalDoctors")
public class HospitalDoctorController {

    @Autowired
    private HospitalDoctorService hospitalDoctorService;

    //change Doctor status

    @RequestMapping(value="/{hospitalId}/{doctorId}", method= RequestMethod.PUT)
    public ResponseEntity<Void> changeHospitalDoctorStatus(@PathVariable ("hospitalId") Long hospitalId, @PathVariable ("doctorId") Long doctorId){

        hospitalDoctorService.changeHospitalDoctorStatus(hospitalId,doctorId);

        return new ResponseEntity("Status Changed", HttpStatus.OK);
    }

}
