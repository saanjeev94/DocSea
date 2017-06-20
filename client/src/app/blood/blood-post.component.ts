/**
 * Created by sonika on 6/17/17.
 */
import {Component, OnInit} from "@angular/core";
import {Blood} from "../model/blood.model";
import {BloodService} from "../services/blood.service";
import {Router} from "@angular/router";
import {EventService} from "../services/event.service";

@Component({
  selector: "docsea-blood-post",
  templateUrl: "./blood-post.component.html",
  styleUrls: ["./blood-post.component.css"]
})
export class BloodPostComponent implements OnInit{
  blood:Blood;
  bloodPostList:any;
  eventList:any;

  constructor(private bloodService:BloodService, private eventService:EventService, private router:Router){
    this.blood=new Blood();
  }

  ngOnInit(){
    this.bloodService.getBloodPost().subscribe((response)=>{
      this.bloodPostList=response;
    });
    this.eventService.getEvents().subscribe((response)=>{
      this.eventList=response;
    });
  }

  onSubmit(){
    this.bloodService.addBloodPost(this.blood).subscribe((response)=>{
      console.log(response);
    });
    this.router.navigate(['/blood-post']);
  }
}