package org.itglance.docsea.web.rest;

import org.itglance.docsea.domain.Schedule;
import org.itglance.docsea.repository.ScheduleRepository;
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


        //Adding Schedule
        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<Void> addSchedule(@RequestBody Schedule schedule, UriComponentsBuilder ucBuilder) {
            System.out.println("Adding Schedule***************************s " );
            List<Schedule> schedules= scheduleRepository.findAll();
            for(Schedule sch:schedules){
                if((sch.getStartTime()==schedule.getStartTime()) &&(sch.getEndTime()==schedule.getEndTime()))
                {
                    System.out.println("The schedule already exists");
                    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
            }
            scheduleRepository.save(schedule);

            System.out.println("Schedule Added");
//            HttpHeaders headers = new HttpHeaders();
//            headers.setLocation(ucBuilder.path("/add/{id}").buildAndExpand(schedule.getId()).toUri());
            return new ResponseEntity<Void>(HttpStatus.CREATED);

        }


        //update Schedule
        @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
        public ResponseEntity<?> updateSchedule(@PathVariable("id") Long id, @RequestBody Schedule schedule) {

            Schedule currentSchedule = scheduleRepository.findOne(id);

            if (currentSchedule == null) {
                System.out.println("Unable to update");
                return new ResponseEntity("Unable to update", HttpStatus.NOT_FOUND);
            }

            currentSchedule.setStartTime(schedule.getStartTime());
            currentSchedule.setEndTime(schedule.getEndTime());

            scheduleRepository.save(currentSchedule);

            System.out.println("Update successful");
            return new ResponseEntity<Schedule>(currentSchedule, HttpStatus.OK);
        }

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
