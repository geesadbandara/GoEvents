import { Component } from '@angular/core';

export class ResponseBodyComponent{
  totalTicketPool:number=0;
  displayLog:string="Waiting";

}

@Component({
  selector: 'app-ticket-count',
  standalone: true,
  imports: [],
  templateUrl: './ticket-count.component.html',
  styleUrl: './ticket-count.component.css',
  providers:[ResponseBodyComponent]
})

export class TicketCountComponent {

  totalTicket: any = {};

  private webSocket: WebSocket;

  constructor(response:ResponseBodyComponent) {
    this.webSocket = new WebSocket('ws://localhost:8080/totalTicket');
    this.webSocket.onmessage = (event) =>{
      //console.log(typeof event.data)
      //this.totalTicket = JSON.parse(event.data)
      response = JSON.parse(event.data);
      console.log(response)
      this.totalTicket = response.totalTicketPool; //if value didn't got updated check the ResponseBodyComponent var in the component in java for same
      console.log(this.totalTicket);
      if((+this.totalTicket)<0){
        this.totalTicket = 0;
      }

    };
  }

}
