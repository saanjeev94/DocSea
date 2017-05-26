import {Injectable} from "@angular/core";
import { Http, Headers } from "@angular/http";
import {Hospital} from "../model/hospital.model";
import 'rxjs/add/operator/map';
import {User} from "../model/user.model";
import {HospitalUser} from "../model/hosptial-user.model";

@Injectable()
export class HospitalService{
  private headers:Headers;
  private hospitalUrl = 'http://localhost:8080/api/hospital/';
  token = localStorage.getItem('curretUser');
  constructor(private http: Http){
    this.headers = new Headers();
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('Authorization', this.token);
  }

  getHospitalByUsername(username: string){
    return this.http.get(this.hospitalUrl+username,this.headers).map(res => res.json());
  }

  addHospital(hospitalUser: HospitalUser){
    // console.log(hospital);
    // this.http.post(this.hospitalUrl, hospital);
    return this.http.post(this.hospitalUrl,hospitalUser,this.headers).map(res => res.json());
  }

  updateHospital(hospitalUser: HospitalUser){
    return this.http.put(this.hospitalUrl,hospitalUser,this.headers).map(res => res.json());
  }

}
