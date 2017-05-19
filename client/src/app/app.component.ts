import { Component } from '@angular/core';
declare var $: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  ngAfterViewInit(){
    $('#navbar ul li').on('click' , function() {
      $('#navbar ul li.active').removeClass('active');
      $(this).addClass('active');
    });
  }
}
