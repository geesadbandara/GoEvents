
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

  hideModal(){
    const element = document.getElementById('popup-modal');
    if(element){
      element.style.display='none';
    }

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
        console.log(data);
        console.log("Successful");
        this.hideModal();
      },
      error => {
        console.error("Error Occurred", error);
      }
    )
  }

  validateInputs(){
    //console.log(this.validateMaxSize())

    //console.log(((+this.totalPool)>(+this.maxPool)))
    //console.log(typeof +this.totalPool);
    console.log(this.validateTotalTicket())
    console.log(this.validateRelease())
    console.log(this.validateRetrieval())
    if(this.validateMaxSize() && this.validateTotalTicket() && this.validateRelease() && this.validateRetrieval()) {
      this.activateSimulation();
    }

  }

  errorMessageMax: String ='';
  errorMessageTotal: String ='';
  errorMessageRelease: String ='';
  errorMessageRetrieval: String ='';



  validateMaxSize(){
    if(isNaN(this.maxPool) || (+this.maxPool)<=0){
      this.errorMessageMax = 'Not a valid integer';
      return false;
    }
    else{
      this.errorMessageMax='';
      //console.log(this.maxPool);
      return true;
      //this.startSimulation();
    }
  }

  validateTotalTicket(){
    if(isNaN(this.totalPool) || (+this.totalPool)<=0 ){
      this.errorMessageTotal = 'Not a valid integer';
      return false;
    }
    else if( (+this.totalPool) > (+this.maxPool)){
      console.log("Total");
      console.log((this.totalPool) > (this.maxPool));
      this.errorMessageTotal = 'Need to be less than max pool';
      return false;

    }
    this.errorMessageTotal = "";
    return true;
  }

  validateRelease(){
    if(isNaN(this.releaseRate) || (this.releaseRate)<=0 ){
      this.errorMessageRelease = 'Not a valid integer';
      return false;
    }

    this.errorMessageRelease = "";
    return true;

  }

  validateRetrieval(){
    if(isNaN(this.retrievalRate) || (+this.retrievalRate)<=0 ){
      this.errorMessageRetrieval = 'Not a valid Integer';
      return false;
    }
    else if((+this.retrievalRate)>(+this.maxPool)){
      this.errorMessageRetrieval = 'Need to be less than max count';
      return false;
    }
    this.errorMessageRetrieval = "";
    return true;
  }

}
