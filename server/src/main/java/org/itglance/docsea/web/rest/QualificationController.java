package org.itglance.docsea.web.rest;

import org.itglance.docsea.service.QualificationService;
import org.itglance.docsea.service.dto.QualificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    QualificationService qualificationService;

    @GetMapping
    public ResponseEntity<?> getAllQualification(){
        List<QualificationDTO> qualifications= qualificationService.getAllQualification();
        if(qualifications.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<QualificationDTO>>(qualifications, HttpStatus.OK);
    }
}
