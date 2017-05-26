/**
 * Created by soni on 5/24/2017.
 */
import {Days} from "./days.model";

export class Schedule{
  public id?:number;
  public startTime?:any;
  public endTime?:any;
  public days:Days;

  constructor(id?:number,startTime?:any,endTime?:any,days?:Days){
    this.id=id?id:null;
    this.startTime=startTime?startTime:null;
    this.endTime=endTime?endTime:null;
    this.days=days?days:new Days();
  }

}
