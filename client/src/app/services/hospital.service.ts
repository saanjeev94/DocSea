import {Injectable} from "@angular/core";
import { Http, Headers } from "@angular/http";
import {Hospital} from "../model/hospital.model";
import 'rxjs/add/operator/map';

@Injectable()
export class HospitalService{
  private hospitalUrl = 'http://localhost:8080/api/hospital';

  private headers: Headers;
  constructor(private http: Http){}

  addHospital(hospital: Hospital){
    return this.http.post(this.hospitalUrl,hospital).map(res => res.json());
  }


}
