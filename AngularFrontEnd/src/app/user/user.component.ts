import { Component, OnInit } from '@angular/core';
import { Users } from '../Users';
import { ObjectServiceService } from '../object-service.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Trainings } from '../Training';
import { Trainer } from './Trainer';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  
  public cources: Trainings[];
  public trainers: Trainer[];
  constructor( private route: Router, private http: HttpClient) { 
    this.http.get("http://localhost:8084/getAllTrainings").subscribe(data => {
      this.cources =<any>data;
      console.log(this.cources);
    });
    this.http.get("http://localhost:8082/getTrainersById/1").subscribe(data => {
      this.trainers =<any>data;
      console.log(this.trainers);
    });
  }

  userReset() {
  }
  
  ngOnInit() {
  }

}
