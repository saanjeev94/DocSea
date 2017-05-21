import {Component, OnInit} from "@angular/core";
declare var $ : any;

@Component({
  selector: 'docsea-hospital-panel',
  templateUrl: './hospital-panel.component.html',
  styleUrls: ['./hospital-panel.component.css']
})

export class HospitalPanelComponent implements OnInit{

  ngOnInit(){

  }

  ngAfterViewInit(){
    $('#hospital-panel-table').dataTable();
  }
}
