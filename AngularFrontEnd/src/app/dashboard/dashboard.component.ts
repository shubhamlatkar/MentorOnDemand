import { Component, OnInit } from '@angular/core';
import { ObjectServiceService } from '../Services/object-service.service';
import { HttpClient } from '@angular/common/http';
import { UserObj } from '../user/UserObj';
import { LogInSignUpService } from '../Services/log-in-sign-up.service';
import { Training } from '../Models/Training';
import { UserService } from '../Services/user.service';
import { TrainerService } from '../Services/trainer.service';
import { User } from 'src/app/Models/User';
import { Cources } from '../Models/Cources';
import { TrainingService } from '../Services/training.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit {

  onClick(event: any) {
      this.searchTerm = event.target.innerText;
      this.searchTerm = this.searchTerm.trim();
  }
  public trainings : Training[];
  public user: UserObj;
  public trainers: User[];
  public cources: Cources[];
  
  trainerOptions: string = 'currentTraining';
  openend: boolean = false;
  searchTerm: string;
  
  constructor(private _objService: ObjectServiceService,private _trainingService: TrainingService, private http: HttpClient, private _loginService:LogInSignUpService, private _trainerService: TrainerService) {  }
  
  ngOnInit() {
    this._objService.getTrainings().subscribe(data => {
      this.trainings = data; 
    });
    this._loginService.temObj.subscribe(data => {
      this.user = data;
    })
    this._trainerService.getTrainers().subscribe(data => {
      this.trainers = data; 
    });
    this._trainingService.getCources().subscribe(data => {
      this.cources = data;
    });
  }
  regsiter() {

  }

  getDetails(event) {
    console.log(event);
  } 
}
