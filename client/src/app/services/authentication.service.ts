import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {User} from "../model/user.model";

@Injectable()
export class AuthenticationService{
  private headers:Headers;

  private loginUrl='http://localhost:8080/api/';

  constructor(private http:Http){
    this.headers= new Headers();
    // this.headers.append('Content-Type','mulipart/form-data');
    // this.headers.append('Accept','application/json');
  }

  login(user: User)
  {
    // console.log(user);
    return this.http.post(this.loginUrl+"login",user).map(res => res.json());
  }

  logout(token: string){
    // console.log(user);
    return this.http.post(this.loginUrl+"logout",token).map(res => res);
  }
}









