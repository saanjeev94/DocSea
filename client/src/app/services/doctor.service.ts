/**
 * Created by soni on 5/16/2017.
 */
import {Headers, Http, RequestOptions} from "@angular/http";
import {Injectable} from "@angular/core";
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class DoctorService{
  private headers:Headers;

  private hospitalDoctorUrl='http://localhost:8080/api/hospitalDoctor';
  private doctorUrl='http://localhost:8080/api/doctors';
  private doctorSearchUrl='http://localhost:8080/api/doctorSearch/';
  private getHospitalUrl='http://localhost:8080/api/hospitalDoctor/';
  token = localStorage.getItem('currentUser');

  constructor(private http:Http){
    this.headers= new Headers();
    this.headers.append('Authorization',this.token);
    this.headers.append('Accept','Application/json');
    // this.headers.append('Content-Type','mulipart/form-data');a
  }

  addDoctor(formdata:FormData){
    console.log(this.headers);
    const options = new RequestOptions({headers: this.headers});
    return this.http.post(this.doctorUrl,formdata,options).map(res=>res.json());
  }

  getHospitalDoctors(){
    const options = new RequestOptions({headers: this.headers});
    return this.http.get(this.hospitalDoctorUrl,options).map(res => res.json() );
  }

  findById(id:number){
    const options = new RequestOptions({headers: this.headers});
    return this.http.get(this.doctorUrl+'/'+id,options).map(res=>res.json());
  }

  updateDoctor(formData:FormData){
    const options = new RequestOptions({headers: this.headers});
    return this.http.put(this.doctorUrl,formData,options).map(res=>res.json());
  }

  search(term: string): Observable<any>{
    // console.log(term);
    return this.http
      .get(this.doctorSearchUrl+'quickSearch/'+term)
      .map(response => response.json());
  }

  searchDoctor(searchTerm: string){
    return this.http.get(this.doctorSearchUrl + searchTerm).map(response => response.json());
  }

  deleteDoctor(id : any){
    return this.http.delete(this.doctorUrl, id).map(res=>res.json());
  }

  getHospitals(id){
    return this.http.get(this.getHospitalUrl+id).map(res=>res.json());
  }

}
