package org.itglance.docsea.web.rest;

import org.itglance.docsea.domain.Speciality;
import org.itglance.docsea.repository.SpecialityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by soni on 5/30/2017.
 */
@CrossOrigin
@RestController
@RequestMapping(value="/api/speciality")
public class SpecialityController {

    SpecialityRepository specialityRepository;

    public SpecialityController(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @GetMapping
    public ResponseEntity<List<Speciality>> getAllSpeciality(){
        List<Speciality> specialities=specialityRepository.findAll();
        return new ResponseEntity<List<Speciality>>(specialities, HttpStatus.OK);
    }
}
