import { Component } from '@angular/core';
import {AuthenticationService} from "./services/authentication.service";
import {LoginComponent} from "./login/login.component";
declare var $: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{

  token: string;

  constructor(private authService: AuthenticationService){

  }

  ngAfterViewInit(){
    $('#navbar ul li').on('click' , function() {
      $('#navbar ul li.active').removeClass('active');
      $(this).addClass('active');
    });
  }

  logout(){
    this.token = localStorage.getItem('currentUser');
    console.log("logout ma pugyo");
    this.authService.logout(this.token).subscribe( (token) => this.onSuccessLogout(token));
  }

  onSuccessLogout(token){
    console.log(token);
    console.log("logout onsuccess ma pugyo");
    localStorage.clear();
    this.authService.isLoggedIn = false;
  }
}
