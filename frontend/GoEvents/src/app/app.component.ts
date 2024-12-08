import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {SideMenueBarComponent} from './side-menue-bar/side-menue-bar.component';
import {PopupModalComponent} from './popup-modal/popup-modal.component';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButton} from "@angular/material/button";
import {TicketCountComponent} from './ticket-count/ticket-count.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, SideMenueBarComponent, PopupModalComponent, MatButton, TicketCountComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'GoEvents';

  showModal(){
    const element = document.getElementById('popup-modal');
    if(element){
      element.style.display='block';
    }
  }
}
