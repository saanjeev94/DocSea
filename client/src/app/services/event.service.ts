import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions} from "@angular/http";
import {Events} from "../model/event.model";
/**
 * Created by sonika on 6/19/17.
 */
@Injectable()
export class EventService{
  public eventUrl='http://localhost:8080/api/events';
  private headers:Headers;
  token = localStorage.getItem('currentUser');

  constructor(private http:Http){
    this.headers= new Headers();
    this.headers.append('Authorization',this.token);
    this.headers.append('Accept','Application/json');

  }

  addEvent(event:Events){
    const options = new RequestOptions({headers:this.headers});
    return this.http.post(this.eventUrl,event,options).map(res=>res.toString());
  }

  getEvents(){
    return this.http.get(this.eventUrl).map(res=>res.json());
  }
}
