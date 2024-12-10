import {Component, Input} from '@angular/core';
import {NgForOf} from '@angular/common';
//import {ResponseBodyComponent} from '../ticket-count/ticket-count.component';

export class ResponseBodyComponent{
  totalTicketPool:number=0;
  displayLog:string="Waiting";

}

@Component({
  selector: 'app-frontend-cli',
  standalone: true,
  imports: [
    NgForOf
  ],
  template:`
    <div class="shell-box" style="background: black;color: white; width:60vw;height: 40vh; border-radius: 25px; padding: 10px">
   <h1>Go Event Shell</h1>
  <div *ngFor="let line of logLines">{{line}}</div>
    </div>
  `,
  //templateUrl: './frontend-cli.component.html',
  styleUrl: './frontend-cli.component.css',
  providers:[ResponseBodyComponent]
})
export class FrontendCliComponent {
  @Input() logLines: any[] = [
  ];
  private webSocket: WebSocket;
  displayLog:String = "";

  constructor(response: ResponseBodyComponent) {
    this.webSocket = new WebSocket('ws://localhost:8080/getLog');
    this.webSocket.onmessage = (event) => {
      response = JSON.parse(event.data);
      console.log(response)
      this.displayLog = response.displayLog; //if value didn't got updated check the ResponseBodyComponent var in the component in java for same
      console.log(this.displayLog);

      if(this.logLines.length<10){
        this.addItem(response);

      }
      else{
        this.removeItem();
      }


    }


  }
  removeItem() {
    this.logLines.splice(0, ((this.logLines.length)-1)); // Remove the product at the given index
  }
  addItem(response:ResponseBodyComponent){
    this.logLines.push(response.displayLog)
  }
}
