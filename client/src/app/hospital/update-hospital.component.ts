import {Component, OnInit} from "@angular/core";
import {HospitalService} from "../services/hospital.service";
import {HospitalUser} from "../model/hosptial-user.model";
import {AddressService} from "../services/address.service";
import {Country} from "../model/country.model";
import {Zone} from "app/model/zone.model";
import {City} from "../model/city.model";
import {District} from "../model/district.model";
import {ActivatedRoute} from "@angular/router";



@Component({
  selector: 'docsea-update-hospital',
  templateUrl: './update-hospital.component.html',
  styleUrls: ['./update-hospital.component.css']
})

export class UpdateHospitalComponent implements OnInit{
  hospitalUser: HospitalUser;

  countryObject: Country[];
  zoneObject: Zone[];
  districtObject: District[];
  cityObject: City[];

  constructor(private hosiptalService: HospitalService, private addressService: AddressService, private route: ActivatedRoute){
    this.hospitalUser = new HospitalUser();
  }

  ngOnInit(){
    this.getCountries();

    this.route.params.subscribe(params=>{
      this.getHospitalDetails(params['username']);
    });
  }

  getHospitalDetails(username: string){
    this.hosiptalService.getHospitalByUsername(username).subscribe((result) => {
      this.hospitalUser=result;
      console.log(result);
    });
  }

  onUpdate(){
    this.hosiptalService.updateHospital(this.hospitalUser).subscribe((result) => console.log(result));
  }

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
