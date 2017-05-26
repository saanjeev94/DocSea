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

  onSuccessLogin(token: any){
    this.token = token._body;
    console.log(this.token);
    let decodedToken = atob(token);
    console.log(decodedToken);
  }


  //push garna lai matra
}
