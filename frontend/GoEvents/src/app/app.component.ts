import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {SideMenueBarComponent} from './side-menue-bar/side-menue-bar.component';
import {PopupModalComponent} from './popup-modal/popup-modal.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, SideMenueBarComponent,PopupModalComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'GoEvents';
}
