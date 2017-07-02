import {AfterViewInit, Component, OnInit} from "@angular/core";
import {DoctorService} from "../services/doctor.service";
import {Events} from "../model/event.model";
import {EventService} from "../services/event.service";
import {Router} from "@angular/router";

declare var $: any;
declare var swal:any;

@Component({
  selector: 'docsea-hospital-panel',
  templateUrl: './hospital-panel.component.html',
  styleUrls: ['./hospital-panel.component.css']
})

export class HospitalPanelComponent implements OnInit, AfterViewInit{

  doctorList: any;
  event:Events;

  constructor(private doctorService:DoctorService, private eventService:EventService, private router:Router){
    this.event=new Events();
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

  onSubmit(){
    console.log("inside submit function");
    this.eventService.addEvent(this.event).subscribe((response)=>{
      console.log(response);
    });
    this.router.navigate(['/events']);
  }
}


