import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions} from "@angular/http";
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
    const options = new RequestOptions({headers: this.headers});
    return this.http.get(this.hospitalUrl+username,options).map(res => res.json());
  }

  addHospital(hospitalUser: HospitalUser){
    const options = new RequestOptions({headers: this.headers});
    return this.http.post(this.hospitalUrl,hospitalUser,options).map(res => res.json());
  }

  updateHospital(hospitalUser: HospitalUser){
    const options = new RequestOptions({headers: this.headers});
    return this.http.put(this.hospitalUrl,hospitalUser,options).map(res => res.json());
  }

}
