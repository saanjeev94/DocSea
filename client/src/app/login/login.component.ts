import {Component} from "@angular/core";
import {User} from "../model/user.model";
import {AuthenticationService} from "../services/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'docsea-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent{
  user: User;
  public tokenBack: any;

  constructor(private authService: AuthenticationService, private router: Router){
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
    this.router.navigate(['/hospital-panel']);
  }
}
