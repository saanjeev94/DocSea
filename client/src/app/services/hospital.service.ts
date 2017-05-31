import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions} from "@angular/http";
import 'rxjs/add/operator/map';
import {HospitalUser} from "../model/hosptial-user.model";
import {Observable} from "rxjs/Observable";

@Injectable()
export class HospitalService{
  private headers:Headers;
  private hospitalUrl = 'http://localhost:9999/api/hospital/';
  token = localStorage.getItem('currentUser');

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

  getAllHospitals(){
    return this.http.get(this.hospitalUrl).map(res => res.json());
  }

  toggleHospitalStatus(id):Observable<any>{
    return this.http.put('http://localhost:9999/api/status/toggleHospital/'+id,id).map(res => res.json());

  }

}
