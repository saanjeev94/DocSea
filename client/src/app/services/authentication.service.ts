import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {User} from "../model/user.model";

@Injectable()
export class AuthenticationService{
  private headers:Headers;
  private loginUrl='http://localhost:8080/api/login';

  constructor(private http:Http){
    this.headers= new Headers();
  }

  login(user: User){
    return this.http.post(this.loginUrl,user).map(res => res.json());
  }
}









