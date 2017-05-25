/**
 * Created by soni on 5/18/2017.
 */
import {Component, OnInit} from '@angular/core';
import {Doctor} from "../model/doctor.model";
import {Contact} from "../model/contact.model";
import {DoctorService} from "../services/doctor.service";
import {ActivatedRoute} from "@angular/router";
declare var $ : any;

@Component({
  selector: 'doctor-profile',
  templateUrl: './doctor-profile.component.html',
  styleUrls: ['./doctor-profile.component.css']
})
export class DoctorProfileComponent implements OnInit{
  doctorList:any;
  doctor:Doctor;

  constructor(private doctorService:DoctorService, private route:ActivatedRoute){
    this.doctor=new Doctor();
  }

  ngOnInit(){
    this.route.params.subscribe(params=>{
      this.getDoctorById(params['id']);
    })
  }

  getDoctorById(id) {
    this.doctorService.findById(id).subscribe(response => {
      this.doctor = response;
      // console.log(this.doctor);
    })
  }
}
