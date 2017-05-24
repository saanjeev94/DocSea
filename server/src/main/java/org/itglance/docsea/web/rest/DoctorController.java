package org.itglance.docsea.web.rest;

import org.itglance.docsea.domain.Doctor;
import org.itglance.docsea.domain.Schedule;
import org.itglance.docsea.repository.DoctorRepository;
import org.itglance.docsea.service.DoctorService;
import org.itglance.docsea.service.ScheduleService;
import org.itglance.docsea.service.dto.DoctorDTO;
import org.itglance.docsea.service.dto.ScheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sriyanka on 5/11/2017.
 */


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
    public ResponseEntity<Void> addDoctor(@RequestBody DoctorDTO doctorDTO) {

        if (doctorService.isDoctorExist(doctorDTO)) {

            return new ResponseEntity("Doctor already exists", HttpStatus.CONFLICT);
        }
        doctorService.addDoctor(doctorDTO);

        return new ResponseEntity("Doctor inserted", HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Doctor>> listAllDoctors() {
        List<Doctor> list = doctorRepository.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<List<Doctor>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }


    //Updating Doctor
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
