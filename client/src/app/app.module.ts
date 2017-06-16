import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { NguiMapModule} from '@ngui/map';

import {AddDoctorComponent} from "./doctor/add-doctor.component";
import {DocseaRoutingModule} from "./docsea-routing.module";
import {UpdateDoctorComponent} from "./doctor/update-doctor.component";
import {DoctorProfileComponent} from "./doctor/doctor-profile.component";
import {RegisterHospitalComponent} from "./hospital/register-hospital.component";
import {SearchDoctorComponent} from "./doctor/search-doctor.compoment";
import {HospitalPanelComponent} from "./hospital/hospital-panel.component";
import {LoginComponent} from "./login/login.component";

import {DoctorService} from "./services/doctor.service";
import {HospitalService} from "./services/hospital.service";
import {DoctorGridView} from "./doctor/doctor-grid-view";
import {AddressService} from "./services/address.service";
import {UpdateHospitalComponent} from "./hospital/update-hospital.component";
import {AuthenticationService} from "./services/authentication.service";
import {AdminComponent} from "./admin/admin.component";
import {ScheduleService} from "./services/schedule.service";
import {QualificationService} from "./services/qualification.service";
import {SpecialityService} from "./services/speciality.service";
import {DoctorDetailsComponent} from "./doctor/doctor-details.component";
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    AddDoctorComponent,
    UpdateDoctorComponent,
    DoctorProfileComponent,
    RegisterHospitalComponent,
    SearchDoctorComponent,
    HospitalPanelComponent,
    LoginComponent,
    DoctorGridView,
    UpdateHospitalComponent,
    AdminComponent,
    DoctorDetailsComponent,
    PageNotFoundComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    DocseaRoutingModule,
    NguiMapModule.forRoot({apiUrl: 'https://maps.google.com/maps/api/js?key=AIzaSyCAk94S98uwgnhxikaz9YiGlz8nn8_SDLQ'})
  ],

  providers: [
    HospitalService,
    DoctorService,
    AddressService,
    AuthenticationService,
    ScheduleService,
    QualificationService,
    SpecialityService
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
