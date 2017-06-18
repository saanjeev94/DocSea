/**
 * Created by sonika on 6/17/17.
 */
import {Component, OnInit} from "@angular/core";
import {Blood} from "../model/blood.model";
import {BloodService} from "../services/blood.service";

@Component({
  selector: "docsea-blood-post",
  templateUrl: "./blood-post.component.html",
  styleUrls: ["./blood-post.component.css"]
})
export class BloodPostComponent implements OnInit{
  blood:Blood;
  bloodPostList:any;

  constructor(private bloodService:BloodService){
    this.blood=new Blood();
  }

  ngOnInit(){
    this.bloodService.getBloodPost().subscribe((response)=>{
      this.bloodPostList=response;
    })
  }
}
