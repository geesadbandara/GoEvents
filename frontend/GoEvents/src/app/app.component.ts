import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {SideMenueBarComponent} from './side-menue-bar/side-menue-bar.component';
import {PopupModalComponent} from './popup-modal/popup-modal.component';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButton} from "@angular/material/button";
import {TicketCountComponent} from './ticket-count/ticket-count.component';
import {HttpClient} from '@angular/common/http';
import {FrontendCliComponent} from './frontend-cli/frontend-cli.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, SideMenueBarComponent, PopupModalComponent, MatButton, TicketCountComponent, FrontendCliComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'GoEvents';

  constructor(private http: HttpClient) {
  }

  showModal(){
    const element = document.getElementById('popup-modal');
    if(element){
      element.style.display='block';
    }
  }

  //activateCode : boolean = true;


  deactivateSimulation(){
    const url = 'http://localhost:8080/api/simulationend';
    //const data={
      //activateCode : this.activateCode
    //}
    const activateCode : boolean = true;

    this.http.post(url,activateCode).subscribe(
      () =>{
        console.log(activateCode);
        console.log("Successful");
      },
      error => {
        console.error("Error Occurred", error);
      }
    )
  }


}
