/**
 * Created by soni on 5/30/2017.
 */
import {Injectable} from "@angular/core";
import {Http, RequestOptions, Headers} from "@angular/http";

@Injectable()
export class SpecialityService{
  private headers:Headers;
  private specialityUrl = 'http://localhost:8080/api/speciality';
  token = localStorage.getItem('currentUser');

  constructor(private http: Http){
    this.headers = new Headers();
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('Authorization', this.token);
  }

  getAllSpeciality(){
    // const options = new RequestOptions({headers: this.headers});
    return this.http.get(this.specialityUrl).map(res=>res.json());
  }
}
