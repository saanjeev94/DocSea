import {Component} from "@angular/core";
import {User} from "../model/user.model";
import {AuthenticationService} from "../services/authentication.service";
import {Router} from "@angular/router";

declare var swal:any;

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
   this.authService.login(this.user).subscribe(
     token => {this.onSuccessLogin(token)},
     response=>{
       console.log(response.status);
       console.log(response._body);
       if (!(response.status === 200)) {
         swal(
           'Oops...',
           response._body,
           'error'
         )
       }
     }
   );
  }

  onSuccessLogin(token){
    this.tokenBack = token;
    localStorage.setItem('currentUser', this.tokenBack.token);
    localStorage.setItem('hospitalId', this.tokenBack.hospitalId);
    localStorage.setItem('userId', this.tokenBack.userId);
    localStorage.setItem('userType', this.tokenBack.userType);
    localStorage.setItem('username', this.tokenBack.username);
    this.router.navigate(['/hospital-panel']);
  }
}
