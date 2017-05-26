/**
 * Created by soni on 5/25/2017.
 */

import {Component} from "@angular/core";
import {ScheduleService} from "../services/schedule.service";
import {ActivatedRoute} from "@angular/router";
import {Schedule} from "../model/schedule.model";
@Component({
  selector: 'doctor-profile',
  templateUrl: './doctor-profile.component.html',
  styleUrls: ['./doctor-profile.component.css']
})
export class DoctorSchedule{
  doctorScheduleList:any;
  days:number[];
  defaultSchedule:Schedule;
  doctorSchedule:Array<Schedule>;
  sundaySchedule:Schedule;
  mondaySchedule:Schedule;
  tuesdaySchedule:Schedule;
  wednesdaySchedule:Schedule;
  thursdaySchedule:Schedule;
  fridaySchedule:Schedule;
  saturdaySchedule:Schedule;

  constructor(private scheduleService:ScheduleService, private route:ActivatedRoute){
    this.days=[1,2,3,4,5,6,7];
    this.defaultSchedule=new Schedule(null,'--:--','--:--',null);
  }

  ngOnInit(){
    this.route.params.subscribe(params=>{
      this.getSchedule(params['id']);
    })
  }

  getSchedule(id:number){
    this.scheduleService.getSchedules(id).subscribe(response=>{
      this.doctorScheduleList=response;
      });
    this.assignSchedule();
  }

  assignSchedule(){
    for(let schedules of this.doctorScheduleList){
      for(let x of this.days){
        if(schedules.days==x){
          this.doctorSchedule[x]=schedules;
        }
        else{
          this.doctorSchedule[x]=this.defaultSchedule;
        }
      }
    }
  }
}
