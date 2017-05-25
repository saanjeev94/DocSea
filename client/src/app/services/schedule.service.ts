/**
 * Created by soni on 5/25/2017.
 */

import {Injectable} from "@angular/core";
@Injectable()
export class ScheduleService{
  private headers:Headers;
  private doctorUrl='http://localhost:8080/api/doctors';

  constructor(private http:Http){
    this.headers= new Headers();
    this.headers.append('Content-Type','mulipart/form-data');
    this.headers.append('Accept','application/json');
  }



  addDoctor(formdata:FormData){
    return this.http.post(this.doctorUrl,formdata,this.headers).map(res=>res.json());
  }

  getDoctors(){
    return this.http.get(this.doctorUrl).map(res => res.json() );
  }

  findById(id:number){
    return this.http.get(this.doctorUrl+'/'+id).map(res=>res.json());
  }

  updateDoctor(formData:FormData){
    console.log("yo chai service hai");
    console.log(formData);
    let headers= new Headers();
    headers.append('Content-Type', 'undefined' );


    // return this.http.put(this.doctorUrl,formData,this.headers);
    return this.http.put(this.doctorUrl,formData,headers).map(res=>res.json());
  }

  deleteDoctor(id : any){
    return this.http.delete(this.doctorUrl, id).map(res=>res.json());
  }
}
