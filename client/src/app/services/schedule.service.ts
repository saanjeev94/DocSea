/**
 * Created by soni on 5/25/2017.
 */

import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
@Injectable()
export class ScheduleService{

public scheduleUrl='http://localhost:8080/api/hospitalDoctors';

  constructor(private http:Http){

  }

  addSchedule(){

  }

  updateSchedule(){

  }

  getSchedules(id:number){
    return this.http.get(this.scheduleUrl+'/'+id).map(res=>res.json());
  }

}
