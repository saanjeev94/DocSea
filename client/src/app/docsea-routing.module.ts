import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterHospitalComponent } from './hospital/register-hospital.component';
import {SearchDoctorComponent} from "./doctor/search-doctor.compoment";
import {HospitalPanelComponent} from "./hospital/hospital-panel.component";
import {LoginComponent} from "./login/login.component";
import {AddDoctorComponent} from "./doctor/add-doctor.component";
import {UpdateDoctorComponent} from "./doctor/update-doctor.component";
import {DoctorProfileComponent} from "./doctor/doctor-profile.component";

const ROUTES: Routes = [
  { path: '', redirectTo: '/search-doctor', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterHospitalComponent },
  { path: 'search-doctor', component: SearchDoctorComponent },
  { path: 'hospital-panel', component: HospitalPanelComponent },
  {path:'register-doctor', component: AddDoctorComponent},
  {path:'update/:id', component: UpdateDoctorComponent},
  {path:'profile/:id', component: DoctorProfileComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(ROUTES) ],
  exports: [ RouterModule ]
})

export class DocseaRoutingModule {

}
