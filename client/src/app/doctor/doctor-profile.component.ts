/**
 * Created by soni on 5/18/2017.
 */
import {Component, OnInit} from '@angular/core';
import {Doctor} from "../model/doctor.model";
import {Contact} from "../model/contact.model";

@Component({
  selector: 'doctor-profile',
  templateUrl: './doctor-profile.component.html',
  styleUrls: ['./doctor-profile.component.css']
})
export class DoctorProfileComponent implements OnInit{
  doctor:Doctor;
  contact:Contact;

  constructor(){

    // this.doctor=new Doctor();
  }

  ngOnInit(){
    // this.contact = new Contact(1,"9860770501","9808524298","sonikamaharjan95@gmail.com","","");
    // this.doctor = new Doctor(1,"Sonika Maharjan","female","MD",null
    //   ,"cardiology",this.contact,"1","sdbkjakcsbnskjdcds");
  }
}
