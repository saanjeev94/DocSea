import {Injectable} from "@angular/core";
import { Http } from "@angular/http";
import {Hospital} from "../model/hospital.model";

@Injectable()
export class HospitalService{
  private hospitalUrl = 'api/hospital'
  constructor(private http: Http){}

  addHospital(hospital: Hospital){
    this.http.post(this.hospitalUrl, hospital);
  }


}
