
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {ChangeDetectionStrategy, Component} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClient,HttpClientModule} from '@angular/common/http';
import {MatAnchor, MatButton} from '@angular/material/button';
import {NgIf} from '@angular/common';


@Component({
  selector: 'app-popup-modal',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatIconModule, FormsModule, HttpClientModule, MatButton, MatAnchor, NgIf],
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './popup-modal.component.html',
  styleUrl: './popup-modal.component.css'
})
export class PopupModalComponent {
  maxPool: number = 0;
  totalPool: number = 0;
  releaseRate : number = 0;
  retrievalRate: number = 0;

  constructor(private http: HttpClient) {
  }
  activateSimulation(){
    const url = 'http://localhost:8080/api/simulation';
    const data={
      maxPool:this.maxPool,
      totalPool:this.totalPool,
      releaseRate:this.releaseRate,
      retrievalRate:this.retrievalRate

    }

    this.http.post(url,data).subscribe(
      () =>{
        console.log("Successful");
      },
      error => {
        console.error("Error Occurred", error);
      }
    )
  }

  validateInputs(){
    if(this.validateMaxSize() && this.validateTotalTicket() && this.validateRelease() && this.validateRetrieval()){
      this.activateSimulation();
    }
  }

  errorMessageMax: String ='';
  errorMessageTotal: String ='';
  errorMessageRelease: String ='';
  errorMessageRetrieval: String ='';


  // @ts-ignore
  validateMaxSize(){
    if(isNaN(this.maxPool) || (this.maxPool)==0){
      this.errorMessageMax = 'Not valid an integer';
    }
    else{
      this.errorMessageMax='';
      return true;
      //this.startSimulation();
    }
  }
  // @ts-ignore
  validateTotalTicket(){
    if(isNaN(this.totalPool) || (this.totalPool)==0){
      this.errorMessageTotal = 'Not valid an integer';
    }
    if((this.totalPool>this.maxPool)){
      this.errorMessageTotal = 'Total ticket count need to be less than Max ticket count';
    }
    if((this.totalPool>this.maxPool) && (isNaN(this.totalPool) || (this.totalPool)==0)){
      this.errorMessageTotal='';
      return true;
      //this.startSimulation();
    }
  }
  // @ts-ignore
  validateRelease(){
    if(isNaN(this.releaseRate) || (this.releaseRate)==0){
      this.errorMessageRelease = 'Not valid an integer';
    }
    if(this.releaseRate>this.totalPool){
      this.errorMessageRelease = 'Release Rate need to be less than max ticket count';
    }
    if((this.releaseRate>this.totalPool) && (isNaN(this.releaseRate) || (this.releaseRate)==0)){
      return true;
    }

  }
  // @ts-ignore
  validateRetrieval(){
    if(isNaN(this.retrievalRate) || (this.retrievalRate)==0){
      this.errorMessageRetrieval = 'Not valid an integer';
    }
    if(this.retrievalRate>this.releaseRate){
      this.errorMessageRetrieval = 'Retrieval rate need to be less than Release Rate ';
    }
    if((isNaN(this.retrievalRate) || (this.retrievalRate)==0) && (this.retrievalRate>this.releaseRate)){
      return true;
    }
  }

}
