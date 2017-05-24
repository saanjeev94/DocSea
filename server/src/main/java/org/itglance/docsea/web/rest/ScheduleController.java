package org.itglance.docsea.web.rest;

import org.itglance.docsea.domain.Schedule;
import org.itglance.docsea.repository.ScheduleRepository;
import org.itglance.docsea.service.ScheduleService;
import org.itglance.docsea.service.dto.ScheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by sriyanka on 5/14/2017.
 */
@RestController
@RequestMapping(value="/api/schedules")
public class ScheduleController {

        @Autowired
        private ScheduleRepository scheduleRepository;

        @Autowired
        private ScheduleService scheduleService;


        //Adding Schedule
        @RequestMapping(method=RequestMethod.POST)
        public ResponseEntity<Void> addSchedule(@RequestBody ScheduleDTO scheduleDTO){
            if(scheduleService.isScheduleExist(scheduleDTO)){
                return new ResponseEntity("Schedule already exists",HttpStatus.CONFLICT);

            }
            scheduleService.addSchedule(scheduleDTO);
            return new ResponseEntity("Schedule added", HttpStatus.OK);

        }

//        //Update Schedule
//        @RequestMapping(method=RequestMethod.PUT)
//        public ResponseEntity<Void> updateSchedule(@RequestBody ScheduleDTO scheduleDTO) {
//            if (scheduleService.isScheduleExist(scheduleDTO)) {
//                scheduleService.updateSchedule(scheduleDTO);
//                return new ResponseEntity("Schedule updated", HttpStatus.OK);
//
//            } else {
//                return new ResponseEntity("Schedule does not exists", HttpStatus.CONFLICT);
//            }
//        }






        //Display

        @RequestMapping(method = RequestMethod.GET)
         public ResponseEntity<List<Schedule>> listAllSchedules() {
            List<Schedule> schedules= scheduleRepository.findAll();
            if (schedules.isEmpty()) {
             return new ResponseEntity(HttpStatus.NO_CONTENT);

            }
            return new ResponseEntity<List<Schedule>>(schedules, HttpStatus.OK);
         }



    }
