package org.itglance.docsea.web.rest;

import org.itglance.docsea.domain.Qualification;
import org.itglance.docsea.domain.Speciality;
import org.itglance.docsea.repository.QualificationRepository;
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
@RequestMapping(value="/api/qualification")
public class QualificationController {

    QualificationRepository qualificationRepository;

    public QualificationController(QualificationRepository qualificationRepository) {
        this.qualificationRepository = qualificationRepository;
    }

    @GetMapping
    public ResponseEntity<List<Qualification>> getAllQualification(){
        List<Qualification> qualifications= qualificationRepository.findAll();
        return new ResponseEntity<List<Qualification>>(qualifications, HttpStatus.OK);
    }
}
