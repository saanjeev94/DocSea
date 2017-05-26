/**
 * Created by soni on 5/18/2017.
 */
import {Component, OnInit} from '@angular/core';
import {Doctor} from "../model/doctor.model";
import {DoctorService} from "../services/doctor.service";
import {ActivatedRoute} from "@angular/router";
import {ScheduleService} from "../services/schedule.service";
declare var $ : any;

@Component({
  selector: 'doctor-profile',
  templateUrl: './doctor-profile.component.html',
  styleUrls: ['./doctor-profile.component.css']
})
export class DoctorProfileComponent implements OnInit{
  doctorList:any;
  sabin:string;
  doctor:Doctor;
  doctorScheduleList:any;
  days:number[];

  constructor(private doctorService:DoctorService,private scheduleService:ScheduleService, private route:ActivatedRoute){
    this.doctor=new Doctor();
    this.days=[1,2,3,4,5,6,7];
  }


  ngOnInit(){
    this.route.params.subscribe(params=>{
      this.getDoctorById(params['id']);
      this.getSchedule(params['id']);
    });
  }

  getDoctorById(id) {
    this.doctorService.findById(id).subscribe(response => {
      this.doctor = response;
    })
  }

  getSchedule(id:number){
    this.scheduleService.getSchedules(id).subscribe(response=>{
      console.log(this.doctorScheduleList);
      this.doctorScheduleList=response;
    });
  }
}
