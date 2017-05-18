/**
 * Created by soni on 5/16/2017.
 */
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AddDoctorComponent} from "./doctor/add-doctor.component";
import {UpdateDoctorComponent} from "./doctor/update-doctor.component";
import {DoctorProfileComponent} from "./doctor/doctor-profile.component";

const routes:Routes=[
  {path:'',redirectTo:'',pathMatch:'full'},
  {path:'register', component: AddDoctorComponent},
  {path:'update', component: UpdateDoctorComponent},
  {path:'profile', component: DoctorProfileComponent}
];

@NgModule({
  imports:[RouterModule.forRoot(routes)],
  exports:[RouterModule]
})
export class AppRoutingModule{

}
