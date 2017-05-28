package org.itglance.docsea.web.rest;

import org.itglance.docsea.domain.Doctor;
import org.itglance.docsea.domain.HospitalDoctor;
import org.itglance.docsea.service.DoctorSearchService;
import org.itglance.docsea.service.dto.DoctorDTO;
import org.itglance.docsea.service.dto.HospitalDoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sriyanka on 5/25/2017.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/api/doctorSearch")
public class DoctorSearchController {

    @Autowired
    private DoctorSearchService doctorSearchService;

    @RequestMapping(value="/{searchString}", method = RequestMethod.GET)
    public ResponseEntity<List<HospitalDoctorDTO>> searchDoctor(@PathVariable String searchString){
       List<HospitalDoctorDTO> hospitalDoctors= doctorSearchService.findDoctor(searchString);

       return new ResponseEntity(hospitalDoctors,HttpStatus.OK);

    }


    //Search all the doctor according to the hospital
    @GetMapping
    public ResponseEntity<?> searchAllDoctorOfHospital(@RequestHeader String Authorization){
        List<Doctor> doctors = new ArrayList<>();
        doctors = doctorSearchService.findAllDoctorsOfHospital(Authorization);
        return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
    }
}
