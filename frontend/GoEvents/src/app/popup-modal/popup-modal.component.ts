
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {ChangeDetectionStrategy, Component} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClient,HttpClientModule} from '@angular/common/http';


@Component({
  selector: 'app-popup-modal',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatIconModule, FormsModule,HttpClientModule],
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

}
