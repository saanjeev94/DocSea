package org.itglance.docsea.web.rest;

import org.itglance.docsea.domain.Doctor;
import org.itglance.docsea.domain.Hospital;
import org.itglance.docsea.domain.Schedule;
import org.itglance.docsea.domain.Status;
import org.itglance.docsea.service.HospitalDoctorService;
import org.itglance.docsea.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sriyanka on 5/23/2017.
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/hospitalDoctor")
public class HospitalDoctorController {

    @Autowired
    private HospitalDoctorService hospitalDoctorService;

    @Autowired
    private SessionService sessionService;

    //change Doctor status

  /*  @RequestMapping(value="/{hospitalId}/{doctorId}", method= RequestMethod.PUT)
    public ResponseEntity<Void> changeHospitalDoctorStatus(@PathVariable ("hospitalId") Long hospitalId, @PathVariable ("doctorId") Long doctorId){

        hospitalDoctorService.changeHospitalDoctorStatus(hospitalId,doctorId);

        return new ResponseEntity("Status Changed", HttpStatus.OK);
    }*/
    /*@RequestMapping(value="/{doctorId}",method=RequestMethod.GET)
    public ResponseEntity<Void> displayHospitalDoctorSchedules(@PathVariable("doctorId") Long doctorId){

        hospitalDoctorService.hospitalDoctorSchedule(doctorId);
        return new ResponseEntity("List of Schedules",HttpStatus.OK);
    }*/

    @GetMapping(value = "/status/{doctorId}")
    public ResponseEntity<?> getStatusOfDoctor(@RequestHeader String Authorization, @PathVariable("doctorId") Long doctorId){
        Status status = hospitalDoctorService.getStatusFromHospitalAndDoctor(doctorId, Authorization);
        return new ResponseEntity<Status>(status, HttpStatus.OK);
    }

    @GetMapping(value = "/{docId}")
    public ResponseEntity<?> gethospitals(@PathVariable("docId") Long docId){
        List<Hospital> hospitals = hospitalDoctorService.getHospitals(docId);
        return  new ResponseEntity<List<Hospital>>(hospitals, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getHospitalDoctors(@RequestHeader String Authorization){
        Long hospitalId=sessionService.checkSession(Authorization).getHospitalId();
        List<Doctor> doctors=hospitalDoctorService.getDoctors(hospitalId);
        return new ResponseEntity<List<Doctor>>(doctors,HttpStatus.OK);
    }
}
