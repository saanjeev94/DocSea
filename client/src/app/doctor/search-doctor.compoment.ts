import {Component, OnInit} from "@angular/core";

import { Observable }   from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {Http} from "@angular/http";
import {DoctorService} from "../services/doctor.service";
import {HospitalDoctor} from "../model/hospital-doctor.model";
import {Router} from "@angular/router";

@Component({
  selector: 'docsea-search-doctor',
  templateUrl: './search-doctor.component.html',
  styleUrls : ['./search-doctor.component.css']
})

export class SearchDoctorComponent implements OnInit{
  searchDoctor: string = '';
  hospitalDoctorList: any;
  doctorList: HospitalDoctor;

  constructor(private doctorService: DoctorService, private router: Router) {}

  ngOnInit(){
  }

  search(term: string): void {
    // console.log(term);
    this.doctorService.search(term)
    .subscribe((result) => this.hospitalDoctorList = result);
    // console.log(this.hospitalDoctorList);
  }

  doctorDetails(doctor: string): void{
    // console.log(doctor);
    this.router.navigate(['/doctor-view',doctor]);
  }
  selectString(hospitalDoctor: string){
    console.log(hospitalDoctor);
    this.searchDoctor = hospitalDoctor;
  }

}
