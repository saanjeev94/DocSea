/**
 * Created by sonika on 6/17/17.
 */
import {Contact} from "./contact.model";

export class Blood{
  public id?:number;
  public post?:string;
  public bloodGroup?:string;
  public deadline?:Date;
  public postDate?:Date;
  public contact?:Contact;


  constructor(id?: number, post?: string, bloodGroup?: string,
              deadline?: Date, postDate?: Date, contact?: Contact) {
    this.id = id? id : null;
    this.post = post?post:null;
    this.bloodGroup = bloodGroup?bloodGroup:null;
    this.deadline = deadline?deadline:null;
    this.postDate = postDate?postDate:null;
    this.contact = contact?contact:new Contact();
  }
}
