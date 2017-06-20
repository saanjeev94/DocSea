import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Events} from "../model/event.model";
/**
 * Created by sonika on 6/19/17.
 */
@Injectable()
export class EventService{
  public eventUrl='http://localhost:9999/api/events'
  constructor(private http:Http){

  }

  addEvent(hospitalId:number, event:Events){
    return this.http.post(this.eventUrl+'/'+hospitalId,event).map(res=>res.json);
  }

  getEvents(){
    return this.http.get(this.eventUrl).map(res=>res.json);
  }
}
