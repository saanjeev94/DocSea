/**
 * Created by soni on 5/16/2017.
 */
import {Doctor} from "../model/doctor.model";
import {Http} from "@angular/http";
import {Injectable} from "@angular/core";


@Injectable()
export class DoctorService{

  private doctorUrl='api/doctor';

  constructor(private http:Http){

  }

  addDoctor(doctor:Doctor){
    return this.http.post(this.doctorUrl,doctor);
  }

  getDoctors(){
    return this.http.get(this.doctorUrl);
  }

  find(){
    return this.http.get(this.doctorUrl+'{id}');
  }

  updateDoctor(doctor:Doctor){
    return this.http.put(this.doctorUrl+'/{id}',doctor);
  }

  deleteDoctor(id : any){
    return this.http.delete(this.doctorUrl, id);
  }

}
