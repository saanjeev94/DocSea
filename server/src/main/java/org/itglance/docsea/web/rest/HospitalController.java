package org.itglance.docsea.web.rest;






import org.itglance.docsea.domain.HospitalUser;
import org.itglance.docsea.service.HospitalService;
import org.itglance.docsea.service.dto.HospitalDTO;
import org.itglance.docsea.service.dto.HospitalUserDTO;
import org.itglance.docsea.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by sanj__000 on 5/10/2017.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class HospitalController {


    @Autowired
    HospitalService hospitalService;

    public static final Logger logger = LoggerFactory.getLogger(HospitalController.class);


    //------------------------hospital resitration-------//
    @RequestMapping(value = "/hospital", method = RequestMethod.POST)
    public ResponseEntity<?> register(@Valid @RequestBody HospitalUserDTO hospitalUser)
    {
        HospitalDTO hospitalDTO = new HospitalDTO(hospitalUser.getHospital());
        UserDTO userDTO = new UserDTO(hospitalUser.getUser());
        logger.info("Creating Hospital : {}", hospitalDTO);


        if(hospitalDTO.getAddress().getCity().getName() == null){
        	 logger.error(" City name should not be null");
             return new ResponseEntity(("Unable to register Hospital, City name should,nt be null"), HttpStatus.CONFLICT);

        }
        else if(hospitalService.isHospitalExist(hospitalDTO, userDTO)){
            logger.error(" Hospital already exist");
            return new ResponseEntity(("Unable to register Hospital. A hospital with registration no. or hospital name" +
                    " or lisence no. or usernme is already exist."), HttpStatus.CONFLICT);
        }
        hospitalService.registerHospital(hospitalDTO, userDTO);
        return new ResponseEntity<String> ("Inserted sucessfully", HttpStatus.OK);
    }

   /* @PutMapping(value = "hospital")
    public ResponseEntity<?> updateHospitalUser(@RequestBody HospitalUserDTO hospitalUserDTO){


        logger.info("Updating Hospital : {}", hospitalUserDTO);
        System.out.println(hospitalUserDTO);

        if(!hospitalService.isHospitalExist(hospitalUserDTO)){
            logger.error("Can't fint hospital in the table");
            return new ResponseEntity(("Unable to register Hospital. A hospital with registration no. or hospital name" +
                    " or lisence no. or usernme is already exist."), HttpStatus.CONFLICT);
        }

    }*/

    //-------------- display testing----//
   @RequestMapping(value = "/hospital", method = RequestMethod.GET)
    public ResponseEntity<List<HospitalUser>> listAllUsers() {
         List<HospitalUser> list = hospitalService.getAllHospitalUser();
        if(list.isEmpty()){
            return new ResponseEntity<List<HospitalUser>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //----------- display hospital by username-------
    @GetMapping(value = "/hospital/{username}")
    public ResponseEntity<?> getHospitalUserById(@PathVariable("username") String username){
        HospitalUser hospitalUser = hospitalService.getHospitalByUsername(username);
        return new ResponseEntity<HospitalUser>(hospitalUser ,HttpStatus.OK);
    }
}
