/**
 * Created by soni on 5/12/2017.
 */
import {Component, OnInit} from '@angular/core';
import {Doctor} from "../model/doctor.model";

@Component({
  selector: 'add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css'],
})
export class AddDoctorComponent implements OnInit{
  title = 'Add Doctor';
  doctor:Doctor;

  constructor(){
    this.doctor=new Doctor();
  }

  ngOnInit(){

  }

  onSubmit(){
    console.log(this.doctor);
  }
}
