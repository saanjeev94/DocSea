import {Component, OnInit} from "@angular/core";
import {HospitalService} from "../services/hospital.service";
import {HospitalUser} from "../model/hosptial-user.model";
import {AddressService} from "../services/address.service";
import {Country} from "../model/country.model";
import {Zone} from "app/model/zone.model";
import {City} from "../model/city.model";
import {District} from "../model/district.model";
import {ActivatedRoute, Router} from "@angular/router";

declare var swal:any;

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

  constructor(private hosiptalService: HospitalService, private addressService: AddressService,
              private route: ActivatedRoute, private router: Router){
    this.hospitalUser = new HospitalUser();
  }

  ngOnInit(){
    this.getCountries();

    this.route.params.subscribe(params=>{
      this.getHospitalDetails(params['username']);
    });
  }

  getHospitalDetails(username: string){
    this.hosiptalService.getHospitalByUsername(username).subscribe(
      result => {
        this.hospitalUser=result;
      },
      error=>{
        if (!(error.status === 200)) {
          swal(
            'Oops...',
            error._body,
            'error'
          )
        }
      }
    );
  }

  onUpdate(){
    this.hosiptalService.updateHospital(this.hospitalUser).subscribe(
      result => {}
      // error=>{
      //   if (!(error.status === 200)) {
      //     swal(
      //       'Oops...',
      //       error._body,
      //       'error'
      //     )
      //   }
      // }
    );
    this.router.navigate(['/hospital-panel']);

  }

  getCountries(){
    this.addressService.getCountries().subscribe(
      countries=> {
        this.onSuccessCountries(countries)
      },
      error=>{
        if (!(error.status === 200)) {
          swal(
            'Oops...',
            error._body,
            'error'
          )
        }
      }
    );
  }

  getZones(country: string){
    this.addressService.getZonesOfCountry(country).subscribe(
      zones=> {
        this.onSuccessZones(zones)
      },
      error=>{
        if (!(error.status === 200)) {
          swal(
            'Oops...',
            error._body,
            'error'
          )
        }
      }
    );
  }

  getDistricts(zone: string){
    this.addressService.getDistrictsOfZone(zone).subscribe(
      districts=> {
        this.onSuccessDistricts(districts)
      },
      error=>{
        if (!(error.status === 200)) {
          swal(
            'Oops...',
            error._body,
            'error'
          )
        }
      });
  }

  getCities(district: string){
    this.addressService.getCitiesOfDistrict(district).subscribe(
      cities=> {
        this.onSuccessCities(cities)
      },
      error=>{
        if (!(error.status === 200)) {
          swal(
            'Oops...',
            error._body,
            'error'
          )
        }
      });
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
