/**
 * Created by soni on 5/25/2017.
 */

import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
@Injectable()
export class ScheduleService{

public scheduleUrl='http://localhost:8080/api/schedules';

  headers:Headers;
  constructor(private http:Http){
    this.headers=new Headers();
    this.headers.append("Authorization","Basic"+"token");
  }

  addSchedule(){

  }

  updateSchedule(){

  }

  getSchedules(id:number){
    return this.http.get(this.scheduleUrl+'/hospitalDoctor/'+id,this.headers).map(res=>res.json());
  }

}
