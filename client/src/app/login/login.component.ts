import {Component} from "@angular/core";
import {User} from "../model/user.model";
import {AuthenticationService} from "../services/authentication.service";
import {current} from "codelyzer/util/syntaxKind";

@Component({
  selector: 'docsea-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent{
  user: User;
  public tokenBack: any;

  constructor(private authService: AuthenticationService){
    this.user = new User();
  }

  onlogin(){
   this.authService.login(this.user).subscribe(token => this.onSuccessLogin(token));
  }

  onSuccessLogin(token){
    this.tokenBack = token;
    localStorage.setItem('currentUser', this.tokenBack.token);
    localStorage.setItem('hospitalId', this.tokenBack.hospitalId);
    localStorage.setItem('userId', this.tokenBack.userId);
    localStorage.setItem('userType', this.tokenBack.userType);
    this.authService.isLoggedIn = true;
  }

  //push garna lai matra
}
