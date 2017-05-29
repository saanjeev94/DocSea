/**
 * Created by soni on 5/16/2017.
 */
import {Headers, Http, RequestOptions} from "@angular/http";
import {Injectable} from "@angular/core";
import {Doctor} from "../model/doctor.model";
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {HospitalDoctor} from "../model/hospital-doctor.model";

@Injectable()
export class DoctorService{
  private headers:Headers;
  private doctorUrl='http://localhost:8080/api/doctors';
  private doctorSearchUrl='http://localhost:8080/api/doctorSearch/';

  token = localStorage.getItem('currentUser');

  constructor(private http:Http){
    this.headers= new Headers();
    this.headers.append('Authorization',this.token);
    this.headers.append('Accept','Application/json');
    // this.headers.append('Content-Type','mulipart/form-data');
  }

  addDoctor(formdata:FormData){
    const options = new RequestOptions({headers: this.headers});
    return this.http.post(this.doctorUrl,formdata,options).map(res=>res.json());
  }

  getDoctors(){
    const options = new RequestOptions({headers: this.headers});
    return this.http.get(this.doctorUrl,options).map(res => res.json() );
  }

  findById(id:number){
    const options = new RequestOptions({headers: this.headers});
    return this.http.get(this.doctorUrl+'/'+id,options).map(res=>res.json());
  }

  updateDoctor(formData:FormData){
    let headers= new Headers();
    // headers.append('Content-Type', 'undefined' );
    // headers.append('Authorization', this.token );
    const options = new RequestOptions({headers: this.headers});
    return this.http.put(this.doctorUrl,formData,options).map(res=>res.json());
  }

  search(term: string): Observable<HospitalDoctor>{
    console.log(term);
    return this.http
      .get(this.doctorSearchUrl+term)
      .map(response => response.json());
  }

  deleteDoctor(id : any){
    return this.http.delete(this.doctorUrl, id).map(res=>res.json());
  }

}
