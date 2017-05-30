import {AfterViewInit, Component, OnInit} from "@angular/core";
import {Hospital} from "../model/hospital.model";
import {HospitalService} from "../services/hospital.service";
import {User} from "../model/user.model";
declare var $: any;

@Component({
  selector: 'docsea-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})

export class AdminComponent implements OnInit, AfterViewInit{
  hospitals: Hospital;
  user: User;

  constructor(private hospitalService: HospitalService){

  }

  ngOnInit(){
    this.getHospitals();
  }

  ngAfterViewInit() {
    setTimeout(() => $("#admin-table").dataTable(),1500);
  }

  getHospitals(){
    this.hospitalService.getAllHospitals().subscribe((result) => this.hospitals = result);
  }

  toggleStatus(id: number){
    this.hospitalService.toggleHospitalStatus(id).subscribe((result) => this.getHospitals());
  }

}
