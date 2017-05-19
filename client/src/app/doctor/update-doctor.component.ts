/**
 * Created by soni on 5/16/2017.
 */
import {Component, OnInit} from '@angular/core';
import {Doctor} from "../model/doctor.model";

@Component({
  selector: 'update-doctor',
  templateUrl: './update-doctor.component.html',
  styleUrls: ['./update-doctor.component.css']
})
export class UpdateDoctorComponent implements OnInit{
  title = 'Update Doctor Information';
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
