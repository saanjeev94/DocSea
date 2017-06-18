/**
 * Created by sonika on 6/18/17.
 */
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Blood} from "../model/blood.model";
@Injectable()
export class BloodService{
  public bloodUrl='http://localhost:9999/api/bloodPost'
  constructor(private http:Http){

  }

  addBloodPost(blood:Blood){
    return this.http.post(this.bloodUrl,blood).map(res=>res.json);
  }

  getBloodPost(){
    return this.http.get(this.bloodUrl).map(res=>res.json);
  }
}
