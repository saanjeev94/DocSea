import {Injectable} from "@angular/core";
import {Http, RequestOptions,Headers} from "@angular/http";
import {Schedule} from "../model/schedule.model";
/**
 * Created by soni on 5/28/2017.
 */
@Injectable()
export class ScheduleService{

  private headers:Headers;
  private scheduleUrl='http://localhost:8080/api/schedules';
  private doctorHospitalUrl='http://localhost:8080/api/schedules/hospitalSchedule';
  token = localStorage.getItem('currentUser');

  constructor(private http:Http){
    this.headers=new Headers;
    this.headers.append('Authorization',this.token);
    this.headers.append('Accept','Application/json');
  }

  addSchedule(schedule:Schedule,id:number){
    const options = new RequestOptions({headers: this.headers});
    return this.http.put(this.scheduleUrl+'/'+id,schedule,options).map(res=>res.json());
  }

  getDoctorAllHospitalSchedule(id){
    const options = new RequestOptions({headers: this.headers});
    console.log(id);
    return this.http.get(this.doctorHospitalUrl+'/'+id,options).map(res=>res.json());
  }

  getHospitalDoctorSchedule(id:number){
    const options = new RequestOptions({headers: this.headers});
    return this.http.get(this.scheduleUrl+'/hospitalDoctor/'+id,options).map(res=>res.json());
  }

}
