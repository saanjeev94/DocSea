import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {DoctorService} from "../services/doctor.service";
import {HospitalDoctor} from "../model/hospital-doctor.model";

declare var swal:any;

@Component({
  selector: "docsea-doctor-grid-view",
  templateUrl: "./doctor-grid-view.html",
  styleUrls: ["./doctor-grid-view.css"]
})

export class DoctorGridView implements OnInit{
  doctorList: HospitalDoctor;
  constructor(private doctorService: DoctorService, private router: Router, private route: ActivatedRoute){
  }

  ngOnInit(){
    this.route.params.subscribe(params=>{
      this.getDoctorDetails(params['doctor']);
    })
  }

  getDoctorDetails(doctor: string){
    this.doctorService.searchDoctor(doctor).subscribe(
      result => {
        this.doctorList = result
      },
      error=>{
        if (!(error.status === 200)) {
          swal(
            'Oops...',
            error._body,
            'error'
          )
        }
      });
  }

}
