package org.itglance.docsea.service;

import org.itglance.docsea.domain.Days;
import org.itglance.docsea.domain.Schedule;
import org.itglance.docsea.repository.DaysRepository;
import org.itglance.docsea.repository.ScheduleRepository;
import org.itglance.docsea.service.dto.ScheduleDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sriyanka on 5/21/2017.
 */

@Service
@Transactional
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final DaysRepository daysRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, DaysRepository daysRepository) {
        this.scheduleRepository = scheduleRepository;
        this.daysRepository = daysRepository;
    }

    public void addSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();

        schedule.setStartTime(scheduleDTO.getStartTime());
        schedule.setEndTime(scheduleDTO.getEndTime());

        Days days = daysRepository.getOne(scheduleDTO.getDays().getId());
        daysRepository.save(days);
        schedule.setDays(days);


        scheduleRepository.save(schedule);

    }


    public void updateSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleRepository.getOne(scheduleDTO.getId());

        schedule.setStartTime(scheduleDTO.getStartTime());
        schedule.setEndTime(scheduleDTO.getEndTime());

        Days days = daysRepository.getOne(scheduleDTO.getDays().getId());
        //days.setDay(scheduleDTO.getDays().getDay());
        daysRepository.save(days);
        schedule.setDays(days);


        scheduleRepository.save(schedule);

    }

    public boolean isScheduleExist(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        schedule = scheduleRepository.findByStartEndTime(scheduleDTO.getStartTime(), scheduleDTO.getEndTime(), scheduleDTO.getDays().getId());

        if (schedule == null) {
            return false;
        } else {
            return true;
        }


    }
    public  Long getScheduleId(ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleRepository.findByStartEndTime(scheduleDTO.getStartTime(), scheduleDTO.getEndTime(), scheduleDTO.getDays().getId());
        System.out.println(schedule);
        return schedule.getId();
    }




}

