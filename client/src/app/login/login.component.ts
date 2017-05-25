import {Component} from "@angular/core";
import {User} from "../model/user.model";
import {AuthenticationService} from "../services/authentication.service";

@Component({
  selector: 'docsea-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent{
  user: User;
  token: string;

  constructor(private authService: AuthenticationService){
    this.user = new User();
  }

  onlogin(){
   this.authService.login(this.user).subscribe(token => this.onSuccessLogin(token));
  }

  onSuccessLogin(token){
    this.token = token;
    console.log(this.token);
    let decodedToken:string = window.atob(token);
    console.log(decodedToken);
  }
}
