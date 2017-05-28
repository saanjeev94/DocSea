/**
 * Created by soni on 5/16/2017.
 */
import {Headers, Http, RequestOptions} from "@angular/http";
import {Injectable} from "@angular/core";


@Injectable()
export class DoctorService{
  private headers:Headers;
  private doctorUrl='http://localhost:8080/api/doctors';

  token = localStorage.getItem('currentUser');

  constructor(private http:Http){
    this.headers= new Headers();
    this.headers.append('Authorization',this.token);
    // this.headers.append('Content-Type','mulipart/form-data');
    this.headers.append('Accept','Application/json');
  }

  addDoctor(formdata:FormData){
    const options = new RequestOptions({headers: this.headers});
    return this.http.post(this.doctorUrl,formdata,options).map(res=>res.json());
  }

  getDoctors(){
    return this.http.get(this.doctorUrl,this.headers).map(res => res.json() );
  }

  findById(id:number){
    return this.http.get(this.doctorUrl+'/'+id,this.headers).map(res=>res.json());
  }

  updateDoctor(formData:FormData){
    let headers= new Headers();
    headers.append('Content-Type', 'undefined' );
    headers.append('Authorization', this.token );

    return this.http.put(this.doctorUrl,formData,headers).map(res=>res.json());
  }

  deleteDoctor(id : any){
    return this.http.delete(this.doctorUrl, id).map(res=>res.json());
  }

}
