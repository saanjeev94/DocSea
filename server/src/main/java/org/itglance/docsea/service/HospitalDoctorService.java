package org.itglance.docsea.service;

import org.itglance.docsea.domain.*;
import org.itglance.docsea.repository.DoctorRepository;
import org.itglance.docsea.repository.HospitalDoctorRepository;
import org.itglance.docsea.repository.HospitalRepository;
import org.itglance.docsea.repository.ScheduleRepository;
import org.itglance.docsea.service.dto.DoctorDTO;
import org.itglance.docsea.service.dto.HospitalDTO;
import org.itglance.docsea.service.dto.ScheduleDTO;
import org.itglance.docsea.service.dto.StatusDTO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sriyanka on 5/23/2017.
 */

@Service
@Transactional
public class HospitalDoctorService {

    public static final Logger logger = LoggerFactory.getLogger(HospitalDoctorService.class);

    private final HospitalDoctorRepository hospitalDoctorRepository;
    private final HospitalRepository hospitalRepository;
    private final DoctorRepository  doctorRepository;
    private final ScheduleRepository scheduleRepository;

    @Autowired
    StatusService statusService;
    @Autowired
    SessionService sessionService;

    public HospitalDoctorService(HospitalDoctorRepository hospitalDoctorRepository, HospitalRepository hospitalRepository, DoctorRepository doctorRepository, ScheduleRepository scheduleRepository) {
        this.hospitalDoctorRepository = hospitalDoctorRepository;
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.scheduleRepository = scheduleRepository;
    }



    /*public void hospitalDoctorSchedule(Long doctorId){
        long hospitalId=1;
        List<Schedule> doctorSchedules=doctorRepository.findScheduleByDoctorId(doctorId);
        List<Schedule> hospitalSchedules=hospitalRepository.findScheduleByHospitalId(hospitalId);
        List<Schedule> hospitalDoctorSchedules=new ArrayList<>();

        for(Schedule currentHospitalSchedule:hospitalSchedules){
            for(Schedule currentDoctorSchedule:doctorSchedules ){
                if(currentHospitalSchedule.getId()==currentDoctorSchedule.getId()){
                    hospitalDoctorSchedules.add(currentDoctorSchedule);
                }
            }
        }

        for(Schedule schedule:hospitalDoctorSchedules){
            logger.info(schedule.toString());
        }
    }
*/

    public StatusDTO getStatusFromHospitalAndDoctor(Long doctorId, String token) {
        Long hospitalId = sessionService.checkSession(token).getHospitalId();
        Hospital hospital = hospitalRepository.findOne(hospitalId);
        Doctor doctor = doctorRepository.findOne(doctorId);
        Status status = hospitalDoctorRepository.findStatusByHospitalDoctor(hospital, doctor);
        System.out.println();
        System.out.println(status);
        return new StatusDTO(status);
    }

    public List<HospitalDTO> getHospitals(Long docId) {
        Doctor doctor = doctorRepository.findOne(docId);
        Status status = statusService.getStatusObject("Active");
        List<Hospital> hospitals= hospitalDoctorRepository.findAllByDoctor(doctor, status);
        List<HospitalDTO> hospitalDTOS = new ArrayList<>();
        for(Hospital h: hospitals){
            hospitalDTOS.add(new HospitalDTO(h));
        }
        return hospitalDTOS;
    }

    public List<DoctorDTO> getDoctors(Long hospitalId) {
        Hospital hospital=hospitalRepository.findOne(hospitalId);
        List<Doctor> doctors=hospitalDoctorRepository.findAllByHospital(hospital);
        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        for(Doctor d: doctors){
            doctorDTOS.add(new DoctorDTO(d));
        }
        return doctorDTOS;
    }
}
