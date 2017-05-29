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
  hospitalDoctorList: HospitalDoctor;

  constructor(private http: Http, private doctorService: DoctorService, private router: Router) {}

  ngOnInit(){
  }

  search(term: string): void {
    // console.log(term);
    this.doctorService.search(term)
    .subscribe((result) => this.hospitalDoctorList = result);
    console.log(this.hospitalDoctorList);
  }

}
