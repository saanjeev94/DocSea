import {Component, OnInit} from "@angular/core";
import {HospitalService} from "../services/hospital.service";
import {HospitalUser} from "../model/hosptial-user.model";



@Component({
  selector: 'docsea-register-hospital',
  templateUrl: './register-hospital.component.html',
  styleUrls: ['./register-hospital.component.css']
})

export class RegisterHospitalComponent implements OnInit{
  hospitalUser: HospitalUser;

  constructor(private hosiptalService: HospitalService){
    this.hospitalUser = new HospitalUser();
  }

  ngOnInit(){

  }

  onRegister(){
    console.log(this.hospitalUser);
    this.hosiptalService.addHospital(this.hospitalUser).subscribe((result) => console.log(result));
  }

}
