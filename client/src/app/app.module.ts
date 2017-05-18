import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {AddDoctorComponent} from "./doctor/add-doctor.component";
import {AppRoutingModule} from "./app-routing.module";
import {UpdateDoctorComponent} from "./doctor/update-doctor.component";
import {DoctorService} from "./doctor/doctor.service";
import {DoctorProfileComponent} from "./doctor/doctor-profile.component";

@NgModule({
  declarations: [
    AppComponent,
    AddDoctorComponent,
    UpdateDoctorComponent,
    DoctorProfileComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [DoctorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
