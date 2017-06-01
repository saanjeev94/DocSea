import {Component} from "@angular/core";
import {Doctor} from "../model/doctor.model";
import {ScheduleService} from "../services/schedule.service";
import {ActivatedRoute} from "@angular/router";
import {DoctorService} from "../services/doctor.service";
import {Hospital} from "../model/hospital.model";

declare var swal:any;

@Component({
  selector: "docsea-doctor-details",
  templateUrl: "./doctor-details.component.html",
  styleUrls: ["./doctor-details.component.css"]
})

export class DoctorDetailsComponent{
  doctor:Doctor;
  hospitalList:Array<Hospital>;
  hospitalSchedules:any;


  constructor(private scheduleService:ScheduleService, private route:ActivatedRoute, private doctorService:DoctorService) {
      this.doctor=new Doctor();
      this.hospitalList=new Array<Hospital>();
  }
  ngOnInit(){
    this.route.params.subscribe(params=>{
      this.displayDoctorDetails(params['id']);
      this.getDoctor(params['id']);
      // this.splitSchedule();
    });
  }

  displayDoctorDetails(id){
    this.scheduleService.getDoctorAllHospitalSchedule(id).subscribe(
      response=>{
        this.hospitalList=response;
        console.log(this.hospitalList);
      },
      error=>{
        if (!(error.status === 200)) {
          swal(
            'Oops...',
            error._body,
            'error'
          )
        }
      }
    );
  }

  getDoctor(id){
    this.doctorService.findById(id).subscribe(
      response=>this.onSuccess(response),
      error=>{
        if (!(error.status === 200)) {
          swal(
            'Oops...',
            error._body,
            'error'
          )
        }
      }
    );
  }
  // splitSchedule(){
  //   for(let hospital of this.hospitalList){
  //   }
  // }

  onSuccess(response){
    this.doctor=response;
  }
}
