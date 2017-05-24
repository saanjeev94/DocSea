package org.itglance.docsea.web.rest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.itglance.docsea.domain.Doctor;
import org.itglance.docsea.repository.DoctorRepository;
import org.itglance.docsea.service.DoctorService;
import org.itglance.docsea.service.dto.DoctorDTO;
import org.itglance.docsea.domain.Schedule;
import org.itglance.docsea.service.ScheduleService;
import org.itglance.docsea.service.dto.ScheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sriyanka on 5/11/2017.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ScheduleService scheduleService;

    //Adding doctor
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addDoctor(
            @RequestParam MultipartFile file,
            @RequestParam String doctor,
            HttpServletRequest request) throws MissingServletRequestPartException{

        System.out.println("***********************");
        System.out.println(file.getName());
        System.out.println(doctor);
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

    //Adding doctor
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addDoctor(@RequestBody DoctorDTO doctorDTO) {

        if (doctorService.isDoctorExist(doctorDTO)) {

            return new ResponseEntity("Doctor already exists", HttpStatus.CONFLICT);
        }
        doctorService.addDoctor(doctorDTO);

        return new ResponseEntity("Doctor inserted", HttpStatus.OK);

    }
    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<Doctor>> listAllDoctors() {
        List<Doctor> list = doctorRepository.findAll();
        if (list.isEmpty()) {
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


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateDoctor(@RequestBody DoctorDTO doctorDTO) {
        if (!doctorService.isDoctorExist(doctorDTO)) {
            return new ResponseEntity("Doctor not found", HttpStatus.CONFLICT);
        } else {
            System.out.println(doctorDTO.toString());
            doctorService.updateDoctor(doctorDTO);
            return new ResponseEntity("Updated Successfully", HttpStatus.OK);
        }


    }

    //Add doctor schedule
    @RequestMapping(value = "/addSchedules/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> addDoctorSchedule(@PathVariable("id") Long id, @RequestBody List<ScheduleDTO> scheduleDTO) {
        List<Schedule> schedule = new ArrayList<>();
        for (ScheduleDTO sch : scheduleDTO) {
            if (!scheduleService.isScheduleExist(sch)) {
                scheduleService.addSchedule(sch);
            }
            doctorService.linkSchedule(id,sch,schedule);
        }
        return new ResponseEntity("New schedule linked", HttpStatus.OK);
    }
}
