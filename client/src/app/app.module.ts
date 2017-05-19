import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {RegisterHospitalComponent} from "./hospital/register-hospital.component";
import {DocseaRoutingModule} from "./docsea-routing.module";
import {SearchDoctorComponent} from "./doctor/search-doctor.compoment";
import {HospitalPanelComponent} from "./hospital/hospital-panel.component";
import {LoginComponent} from "./login/login.component";

import {HospitalService} from "./services/hospital.service";

@NgModule({
  declarations: [
    AppComponent,
    RegisterHospitalComponent,
    SearchDoctorComponent,
    HospitalPanelComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    DocseaRoutingModule
  ],
  providers: [
    HospitalService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
