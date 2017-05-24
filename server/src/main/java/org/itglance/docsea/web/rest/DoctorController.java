package org.itglance.docsea.web.rest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.itglance.docsea.domain.Doctor;
import org.itglance.docsea.repository.DoctorRepository;
import org.itglance.docsea.service.DoctorService;
import org.itglance.docsea.service.dto.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by sriyanka on 5/11/2017.
 */

@CrossOrigin
@RestController
@RequestMapping(value="/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorRepository doctorRepository;

    //Adding doctor
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addDoctor(
            @RequestParam MultipartFile file,
            @RequestParam String doctor,
            HttpServletRequest request) throws MissingServletRequestPartException{

        System.out.println("***********************");
        System.out.println(file.getName());
        System.out.println(doctor);
        Doctor doctor1=new Doctor();
        ObjectMapper objectMapper=new ObjectMapper();

        try{
            DoctorDTO doctorDTO=objectMapper.readValue(doctor,DoctorDTO.class);
            String photoName=doctorService.renamePhoto(file);
            System.out.println(photoName);
            doctorDTO.setPhoto(photoName);
            System.out.println(doctorDTO.toString());
            if(doctorService.isDoctorExist(doctorDTO)){
                return new ResponseEntity("Doctor already exists", HttpStatus.CONFLICT);
            }
            doctorService.addDoctor(doctorDTO);
        }catch (JsonParseException e1) {
            e1.printStackTrace();
        } catch (JsonMappingException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return new ResponseEntity("Doctor inserted", HttpStatus.OK);
    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<Doctor>> listAllDoctors() {
        List<Doctor> list = doctorRepository.findAll();
        if(list.isEmpty()){
            return new ResponseEntity<List<Doctor>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    //Updating Doctor
    @PutMapping
    public ResponseEntity<?> updateDoctor(
            @RequestParam(required = false) MultipartFile file,
            @RequestParam(required = true) String doctor,
            HttpServletRequest request) throws MissingServletRequestPartException,IOException{

        System.out.println("*********************************************************************");
        Doctor doctor1=new Doctor();
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try{
            DoctorDTO doctorDTO=objectMapper.readValue(doctor,DoctorDTO.class);
            if(file!=null) {
                String photoName = doctorService.renamePhoto(file);
                System.out.println(photoName);
                doctorDTO.setPhoto(photoName);
                System.out.println(doctorDTO.toString());
            }
            if(!doctorService.isDoctorExist(doctorDTO.getId())){
                return new ResponseEntity<String>(("Cannot find doctor in database."), HttpStatus.CONFLICT);
            }else if(!doctorService.validateNmcforUpdate(doctorDTO)){
                return new ResponseEntity<String>(("Doctor with the nmcNumber "+doctorDTO.getNmcNumber()+" already exists"), HttpStatus.CONFLICT);
            }
            doctorService.addDoctor(doctorDTO);
        }catch (JsonParseException e1) {
            e1.printStackTrace();
        } catch (JsonMappingException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return new ResponseEntity("Doctor updated", HttpStatus.OK);

    }


    @RequestMapping( method = RequestMethod.GET, value="/{id}")
    public ResponseEntity<Doctor> getDoctorByID(@PathVariable("id") Long id) {
        Doctor doctor=doctorRepository.findById(id);
        if(doctor.equals(null)){
            return new ResponseEntity<Doctor>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

}
