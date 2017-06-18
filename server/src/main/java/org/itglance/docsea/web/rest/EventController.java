package org.itglance.docsea.web.rest;

import org.itglance.docsea.domain.Event;
import org.itglance.docsea.repository.EventRepository;
import org.itglance.docsea.service.EventService;
import org.itglance.docsea.service.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sriyanka on 6/12/17.
 */

@RestController
@RequestMapping(value="/api/events")
public class EventController {

    @Autowired
    private final EventRepository eventRepository;

    @Autowired
    private final EventService eventService;

    public EventController(EventRepository eventRepository, EventService eventService) {
        this.eventRepository = eventRepository;
        this.eventService = eventService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> addEvents(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        System.out.println("***********************************************************88");
        System.out.println(eventDTO.toString());
        if (!(eventService.isEventExist(id, eventDTO.getDate(), eventDTO.getName(), eventDTO.getTime()))) {
            eventService.addEvent(eventDTO, id);
            return new ResponseEntity<String>("Inserted sucessfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Event already exist", HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Event>> listAllEvents() {
        List<Event> list = eventRepository.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    public ResponseEntity<?> updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) {

        if (eventService.updateHospital(eventDTO,id)){
           return new ResponseEntity<String>("Update successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Event doesn't exist", HttpStatus.CONFLICT);
        }

    }
}
