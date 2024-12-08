import { Component } from '@angular/core';

@Component({
  selector: 'app-ticket-count',
  standalone: true,
  imports: [],
  templateUrl: './ticket-count.component.html',
  styleUrl: './ticket-count.component.css'
})
export class TicketCountComponent {

  totalTicket: any = {};
  private webSocket: WebSocket;

  constructor() {
    this.webSocket = new WebSocket('ws://localhost:8080/totalTicket');
    this.webSocket.onmessage = (event) =>{
      //console.log(typeof event.data)
      this.totalTicket = JSON.parse(event.data)
      if((+this.totalTicket)<0){
        this.totalTicket = 0;

      }
    };
  }

}
