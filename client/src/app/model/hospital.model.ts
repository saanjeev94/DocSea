
import {Contact} from "./contact.model";
import {Address} from "./address.model";

export class Hospital{
  id: number;
  name: string;
  contact: Contact;
  address: Address;
  lisenceNo: string;
  registrationNo: string;

  constructor(id?: number, name?: string, contact?: Contact, address?: Address, lisenceNo?: string, registrationNo?: string){
    this.id = id ? id : null;
    this.name = name ? name : null;
    this.contact = contact ? contact : new Contact();
    this.address = address ? address : new Address();
    this.lisenceNo = lisenceNo ? lisenceNo : null;
    this.registrationNo = registrationNo ? registrationNo : null;
  }
}
