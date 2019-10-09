import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-evaluation-app';
  
  constructor(private http: HttpClient) {
    // this.http.get("http://localhost:8080/get").subscribe(data=>{

    //  console.log(data);
    // })
  }

}
