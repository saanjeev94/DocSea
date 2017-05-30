import {AfterViewInit, Component, OnInit} from "@angular/core";
import {DoctorService} from "../services/doctor.service";

declare var $: any;

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
    this.doctorService.getDoctors().subscribe((response) => {
      // console.log(response);
      this.doctorList = response;
    })
  }

  ngAfterViewInit() {
    setTimeout(() => $("#hospital-panel-table").dataTable(),1500);
  }
}
