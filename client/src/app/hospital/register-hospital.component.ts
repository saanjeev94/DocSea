import {Component} from "@angular/core";
import {FormGroup} from "@angular/forms";
import {Hospital} from "../model/hospital.model";
import {HospitalService} from "../services/hospital.service";



@Component({
  selector: 'docsea-register-hospital',
  templateUrl: './register-hospital.component.html',
  styleUrls: ['./register-hospital.component.css']
})

export class RegisterHospitalComponent{
  hospital: Hospital;

  constructor(private hosiptalService: HospitalService){
    this.hospital = new Hospital();
  }

  onRegister(form: FormGroup){
    // console.log(form);
    this.hosiptalService.addHospital(this.hospital);
  }

}
