package org.itglance.docsea.web.rest;

import org.itglance.docsea.domain.Doctor;
import org.itglance.docsea.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by sriyanka on 5/11/2017.
 */


@RestController
@RequestMapping(value="/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;


    //Adding Doctor
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addDoctor(@RequestBody Doctor doctor, UriComponentsBuilder ucBuilder) {
        System.out.println("Adding Doctor " + doctor.getName());
        List<Doctor> doctors=doctorRepository.findAll();
        for(Doctor doc:doctors){
            if(doc.getNmcNumber()==(doctor.getNmcNumber()))
            {
                System.out.println("A Doctor with nmcNumber " + doctor.getNmcNumber() + " already exist");
                return new ResponseEntity<Void>(HttpStatus.CONFLICT);
            }
        }
        doctorRepository.save(doctor);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/add/{name}").buildAndExpand(doctor.getName()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

    }

    //update Doctor
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDoctor(@PathVariable("id") Long id, @RequestBody Doctor doctor) {

        Doctor currentDoctor = doctorRepository.findOne(id);

        if (currentDoctor == null) {
            //logger.error("Unable to update. Doctor with id {} not found.", id);
            return new ResponseEntity("Unable to update", HttpStatus.NOT_FOUND);
        }

        currentDoctor.setNmcNumber(doctor.getNmcNumber());
        currentDoctor.setName(doctor.getName());
        currentDoctor.setQualification(doctor.getQualification());
        currentDoctor.setPhoto(doctor.getPhoto());
        currentDoctor.setSpeciality(doctor.getSpeciality());
        currentDoctor.setContact(doctor.getContact());
        currentDoctor.setDetails(doctor.getDetails());

        doctorRepository.save(currentDoctor);



        return new ResponseEntity<Doctor>(currentDoctor, HttpStatus.OK);
    }

}