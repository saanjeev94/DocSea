import {Component} from "@angular/core";
import {Hospital} from "../model/hospital.model";
import {HospitalService} from "../services/hospital.service";
import {User} from "../model/user.model";
import {HospitalUser} from "../model/hosptial-user.model";



@Component({
  selector: 'docsea-register-hospital',
  templateUrl: './register-hospital.component.html',
  styleUrls: ['./register-hospital.component.css']
})

export class RegisterHospitalComponent{
  hospitalUser: HospitalUser;
  // hospital: Hospital;
  // user: User;

  constructor(private hosiptalService: HospitalService){
    this.hospitalUser = new HospitalUser();
    // this.hospital = new Hospital();

  }

  onRegister(){
    console.log(this.hospitalUser);
    this.hosiptalService.addHospital(this.hospitalUser).subscribe((result) => console.log(result));
  }

}
