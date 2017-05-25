import {Component} from "@angular/core";
import {User} from "../model/user.model";


@Component({
  selector: 'docsea-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent{
  user: User;


}
