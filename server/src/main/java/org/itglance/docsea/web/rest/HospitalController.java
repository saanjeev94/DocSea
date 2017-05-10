package org.itglance.docsea.web.rest;



import org.itglance.docsea.service.HospitalService;
import org.itglance.docsea.service.dto.HospitalDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by sanj__000 on 5/10/2017.
 */

@RestController
@RequestMapping(value = "/hospital")
public class HospitalController {


    @Autowired
    HospitalService hospitalService;

    public static final Logger logger = LoggerFactory.getLogger(HospitalController.class);


    //------------------------hospital resitration-------//

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody HospitalDTO hospitalDTO)
    {
        logger.info("Creating Hospital : {}", hospitalDTO);
    }
}
