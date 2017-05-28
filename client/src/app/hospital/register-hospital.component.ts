import {Component, OnInit} from "@angular/core";
import {HospitalService} from "../services/hospital.service";
import {HospitalUser} from "../model/hosptial-user.model";
import {AddressService} from "../services/address.service";
import {Country} from "../model/country.model";
import {Zone} from "app/model/zone.model";
import {City} from "../model/city.model";
import {District} from "../model/district.model";
import {AuthenticationService} from "../services/authentication.service";
import {Router} from "@angular/router";



@Component({
  selector: 'docsea-register-hospital',
  templateUrl: './register-hospital.component.html',
  styleUrls: ['./register-hospital.component.css']
})

export class RegisterHospitalComponent implements OnInit{
  hospitalUser: HospitalUser;

  countryObject: Country[];
  zoneObject: Zone[];
  districtObject: District[];
  cityObject: City[];

  constructor(private hosiptalService: HospitalService, private addressService: AddressService,
                private authService: AuthenticationService, private router: Router){
    this.hospitalUser = new HospitalUser();
  }

  ngOnInit(){
    this.getCountries();
  }

  onRegister(){
    this.hosiptalService.addHospital(this.hospitalUser).subscribe((result) => this.hospitalUser = result);
    this.router.navigate((['/login']));
  }

  // onSuccessRegister(result){
  //   this.router.navigate(['/login']);
  // }

  getCountries(){
    this.addressService.getCountries().subscribe(countries=>this.onSuccessCountries(countries), () => console.log('error'));
  }

  getZones(country: string){
    this.addressService.getZonesOfCountry(country).subscribe(zones=>this.onSuccessZones(zones), () => console.log('error'));
  }

  getDistricts(zone: string){
    this.addressService.getDistrictsOfZone(zone).subscribe(districts=>this.onSuccessDistricts(districts), () => console.log('error'));
  }

  getCities(district: string){
    this.addressService.getCitiesOfDistrict(district).subscribe(cities=>this.onSuccessCities(cities), () => console.log('error'));
  }

  onSuccessCountries(res){
    this.countryObject=res;
  }

  onSuccessZones(res){
  this.zoneObject=res;
}

  onSuccessDistricts(res){
    this.districtObject=res;;
  }

  onSuccessCities(res){
    this.cityObject=res;
  }
}
