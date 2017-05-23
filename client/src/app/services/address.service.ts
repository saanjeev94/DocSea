import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";

import {Observable} from "rxjs/Observable";

@Injectable()
export class AddressService{

  private addressUrl='http://localhost:8080/api/addresses';

  constructor(private http:Http){

  }

  getCountries(): Observable<any>{
    return this.http.get(this.addressUrl+"/countries")
      .map((res: Response) => res.json());
  }

  getZones(): Observable<any> {
    return this.http.get(this.addressUrl+"/zones")
      .map((res: Response) => res.json());
  }

  getZonesOfCountry(country: string): Observable<any> {
    console.log(country);
    return this.http.get(this.addressUrl+"/zones/"+country).map((res: Response) => res.json());

  }

  getDistricts(): Observable<any> {
    return this.http.get(this.addressUrl+"/districts")
      .map((res: Response) => res.json());
  }

  getDistrictsOfZone(zone: string): Observable<any> {
    return this.http.get(this.addressUrl+"/districts/"+zone).map((res: Response) => res.json());
  }

  getCities(): Observable<any> {
    return this.http.get(this.addressUrl+"/cities")
      .map((res: Response) => res.json());
  }

  getCitiesOfDistrict(district: string): Observable<any> {
    return this.http.get(this.addressUrl+"/cities/"+district).map((res: Response) => res.json());
  }


}
