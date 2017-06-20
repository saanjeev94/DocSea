import {Hospital} from "./hospital.model";
/**
 * Created by sonika on 6/18/17.
 */

export class Events{
  public id?:number;
  public name?:string;
  public hospital?:Hospital;
  public description?:string;
  public date?:Date;
  public time?:string;
  public photo?:string;
  public location?:string;


  constructor(id?: number, name?: string, hospital?: Hospital, description?: string,
              date?: Date, time?: string, photo?: string, location?: string) {
    this.id = id?id:null;
    this.name = name?name:null;
    this.hospital = hospital?hospital:new Hospital();
    this.description = description?description:null;
    this.date = date?date:null;
    this.time = time?time:null;
    this.photo = photo?photo:null;
    this.location=location?location:null;
  }
}
