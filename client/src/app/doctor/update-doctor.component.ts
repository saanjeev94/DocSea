/**
 * Created by soni on 5/16/2017.
 */
import {Component, OnInit} from '@angular/core';
import {Doctor} from "../model/doctor.model";
import {DoctorService} from "../services/doctor.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class UpdateDoctorComponent implements OnInit{
  title = 'Update Doctor Information';
  doctor:Doctor;
  photofile:File=null;

  constructor(private doctorService:DoctorService, private route:ActivatedRoute){
    this.doctor=new Doctor();
  }

  ngOnInit(){
    this.route.params.subscribe(params=>{
      this.getDoctorDetails(params['id']);
    })
  }

  onChange(event) {
    let file = event.srcElement.files;
    this.photofile=file[0];
  }

  onSubmit(){
    let formdata:FormData=new FormData();
    formdata.append('photofile',this.photofile);
    formdata.append('doctor',JSON.stringify(this.doctor));
    console.log(this.doctor);
    console.log(this.photofile);
    this.doctorService.updateDoctor(formdata);
  }

  getDoctorDetails(id:number){
    this.doctorService.findById(id).subscribe(response=>{
      this.doctor=response;
      console.log(this.doctor);
    })
  }
}
