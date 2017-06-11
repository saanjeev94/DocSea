import {AfterViewInit, Component, OnInit} from "@angular/core";
import {DoctorService} from "../services/doctor.service";

declare var $: any;
declare var swal:any;

@Component({
  selector: 'docsea-hospital-panel',
  templateUrl: './hospital-panel.component.html',
  styleUrls: ['./hospital-panel.component.css']
})

export class HospitalPanelComponent implements OnInit, AfterViewInit{

  doctorList: any;

  constructor(private doctorService:DoctorService){

  }

  ngOnInit(){
    this.getAllDoctorList();
  }

  getAllDoctorList(){
    this.doctorService.getHospitalDoctors().subscribe(
      data=>{
        this.doctorList = data;
      },
      response=>{
        if (!(response.status === 200)) {
          swal(
            'Oops...',
            response._body,
            'error'
          )
        }
      }
    )}

  ngAfterViewInit() {
    setTimeout(() => $("#hospital-panel-table").dataTable(),1500);
  }
}
