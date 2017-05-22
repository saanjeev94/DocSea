import {Injectable} from "@angular/core";
import { Http, Headers } from "@angular/http";
import {Hospital} from "../model/hospital.model";
import 'rxjs/add/operator/map';
import {User} from "../model/user.model";
import {HospitalUser} from "../model/hosptial-user.model";

@Injectable()
export class HospitalService{
  private headers:Headers;
  private hospitalUrl = 'http://localhost:8080/api/hospital';
  constructor(private http: Http){
    // this.headers.append('Content-Type', 'application/json');
  }

  addHospital(hospitalUser: HospitalUser){
    // console.log(hospital);
    // this.http.post(this.hospitalUrl, hospital);
    return this.http.post(this.hospitalUrl,hospitalUser).map(res => res.json());
  }

}
