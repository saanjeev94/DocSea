package org.itglance.docsea.web.rest;

import org.itglance.docsea.domain.HospitalUser;
import org.itglance.docsea.domain.Session;
import org.itglance.docsea.domain.User;
import org.itglance.docsea.service.SessionService;
import org.itglance.docsea.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

/**
 * Created by soni on 5/8/2017.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    SessionService sessionService;

    @Autowired
    UserService userService;

    public static final Logger logger = LoggerFactory.getLogger(HospitalController.class);

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody User user){
        System.out.println(user.toString());
        logger.info("Validating username and password");
        String encodedMainToken = userService.validateLogin(user);
        if(encodedMainToken == null){
            logger.error("Invalid Username or Password.");
            return new ResponseEntity<String>("Invalid Username or Password.", HttpStatus.CONFLICT);
        }
        return  new ResponseEntity<String>(new String(encodedMainToken), HttpStatus.OK);
    }
}
