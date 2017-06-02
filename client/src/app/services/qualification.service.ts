/**
 * Created by soni on 5/30/2017.
 */
import {Injectable} from "@angular/core";
import {Http, RequestOptions, Headers} from "@angular/http";

@Injectable()
export class QualificationService{
  private headers:Headers;
  private qualificationUrl = 'http://localhost:9999/api/qualification';
  token = localStorage.getItem('currentUser');

  constructor(private http: Http){
    this.headers = new Headers();
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('Authorization', this.token);
  }

  getAllQualification(){
    // const options = new RequestOptions({headers: this.headers});
    return this.http.get(this.qualificationUrl).map(res=>res.json());
  }
}
