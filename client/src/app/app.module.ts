import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';

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
import {NgxDatatableModule} from "@swimlane/ngx-datatable";


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
    UpdateHospitalComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    NgxDatatableModule,
    DocseaRoutingModule
  ],

  providers: [
    HospitalService,
    DoctorService,
    AddressService
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
