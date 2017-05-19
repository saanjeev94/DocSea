import {Injectable} from "@angular/core";
import { Http, Headers } from "@angular/http";
import {Hospital} from "../model/hospital.model";
import 'rxjs/add/operator/map';

@Injectable()
export class HospitalService{
  private headers:Headers;
  private hospitalUrl = 'http://localhost:8080/api/hospital';
  constructor(private http: Http){
    // this.headers.append('Content-Type', 'application/json');
  }

  addHospital(hospital: Hospital){
    // console.log("yo hoo the ");
    // console.log(hospital);
    return this.http.post(this.hospitalUrl,hospital).map(res => res.json());
    // this.http.post(this.hospitalUrl, hospital);
  }


}
