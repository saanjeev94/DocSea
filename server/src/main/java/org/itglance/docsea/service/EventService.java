package org.itglance.docsea.service;

import org.itglance.docsea.domain.Event;
import org.itglance.docsea.domain.Hospital;
import org.itglance.docsea.repository.EventRepository;
import org.itglance.docsea.repository.HospitalRepository;
import org.itglance.docsea.service.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sriyanka on 6/12/17.
 */

@Service
public class EventService {

    @Autowired
    private final EventRepository eventRepository;

    @Autowired
    private final HospitalRepository hospitalRepository;


    public EventService(EventRepository eventRepository, HospitalRepository hospitalRepository) {
        this.eventRepository = eventRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public void addEvent(EventDTO eventDTO, Long hospitalId){
        //Event event1=eventRepository.isEventExist(hospitalId,eventDTO.getDate());
        Event event=new Event();
        event.setName(eventDTO.getName());
        event.setDescription(eventDTO.getDescription());
        event.setDate(eventDTO.getDate());
        event.setTime(eventDTO.getTime());
        event.setPhoto(eventDTO.getPhoto());

        Hospital hospital=hospitalRepository.findOne(hospitalId);
        event.setHospital(hospital);
        System.out.println("**********************************************************");
        System.out.println(event.toString());

        eventRepository.save(event);

    }

    public boolean updateHospital(EventDTO eventDTO, Long id){
        Event event=eventRepository.findById(id);
        if(event!=null){
            event.setName(eventDTO.getName());
            event.setDescription(eventDTO.getDescription());
            event.setDate(eventDTO.getDate());
            event.setTime(eventDTO.getTime());
            event.setPhoto(eventDTO.getPhoto());

            eventRepository.save(event);
            return true;

        }
        return false;



    }

    public boolean isEventExist(Long id, String date, String name, String time){
        Event event= eventRepository.isEventExist(id, date, name, time);
        if(event!=null){
            return true;
        }
        else{
            return false;
        }

    }


}


