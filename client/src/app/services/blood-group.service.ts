/**
 * Created by sonika on 6/20/17.
 */
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";


@Injectable()
export class BloodGroupService{
  private bloodGroupUrl="http://localhost:9999/api/bloodGroups";

  constructor(private http:Http){

  }

  getBloodGroup(){
    return this.http.get(this.bloodGroupUrl).map(response=>response.json());
  }

}
