/**
 * Created by soni on 5/16/2017.
 */
import {Component, OnInit} from '@angular/core';
import {Doctor} from "../model/doctor.model";
import {DoctorService} from "../services/doctor.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthenticationService} from "../services/authentication.service";

@Component({
  selector: 'add-doctor',
  templateUrl: './update-doctor.component.html',
  styleUrls: ['./update-doctor.component.css']
})
export class UpdateDoctorComponent implements OnInit{
  doctor:Doctor;
  photofile:File=null;

  constructor(private doctorService:DoctorService, private route:ActivatedRoute, private router: Router,
              private authService: AuthenticationService){
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

  update(){
    let formdata:FormData = new FormData();
    formdata.append('file',this.photofile);
    formdata.append('doctor',JSON.stringify(this.doctor));
    this.doctorService.updateDoctor(formdata).subscribe((response)=> this.doctor = response);
    this.router.navigate(['/hospsital-panel']);
  }

  getDoctorDetails(id:number){
    this.doctorService.findById(id).subscribe(response=>{
      this.doctor=response;
    })
  }
}
