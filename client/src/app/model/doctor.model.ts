/**
 * Created by soni on 5/14/2017.
 */
import {Contact} from "./contact.model";
import {Speciality} from "./speciality.model";

export class Doctor{
  public id?:number;
  public name?:string;
  public gender?:string;
  public qualification?:string;
  public photo?:string;
  public speciality?: Speciality;
  public contact?:Contact;
  public nmcNumber?:string;
  public details?:string;

  constructor(id?:number,name?:string,gender?:string,qualification?:string,photo?:string,speciality?:Speciality,contact?:Contact,nmcNumber?:string,details?:string){
    this.id=id?id:null;
    this.name=name?name:null;
    this.gender=gender?gender:null;
    this.qualification=qualification?qualification:null;
    this.photo=photo?photo:null;
    this.speciality=speciality?speciality:new Speciality();
    this.contact=contact?contact:new Contact();
    this.nmcNumber=nmcNumber?nmcNumber:null;
    this.details=details?details:null;
  }
}
