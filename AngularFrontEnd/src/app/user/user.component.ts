import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Training } from '../Models/Training';
import { Trainer } from './Trainer';
import { UserObj } from './UserObj';
import { LogInSignUpService } from '../Services/log-in-sign-up.service';
import { UserService } from '../Services/user.service';
import { User } from '../Models/User';
import { Payment } from '../Models/Payment';
import { Notifications } from '../Models/Notifications';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  
  public cources: Training[];
  public trainers: Trainer[];

  public user: UserObj;

  public currentUser: User;
  public currentPayments: Payment;
  public currentNotifications: Notifications;

  constructor(private _userService: UserService, private _loginService:LogInSignUpService, private route: Router, private http: HttpClient) { 
    // this.http.get("http://localhost:8084/getAllTrainings").subscribe(data => {
    //   this.cources =<any>data;
    //   console.log(this.cources);
    // });
    // this.http.get("http://localhost:8082/getTrainersById/1").subscribe(data => {
    //   this.trainers =<any>data;
    //   console.log(this.trainers);
    // });
  }

  userReset() {
  }
  
  ngOnInit( ) {
    this._loginService.temObj.subscribe(data => {
      this.user=<any>data;
    });
    this._userService.getUser(this.user.id).subscribe(data => {
      this.currentUser = data;
    });
    this._userService.getPayments().subscribe(data => {
      this.currentPayments = data;
    });
    this._userService.getNotificationsById(this.user.id).subscribe(data => {
      this.currentNotifications = data;
      console.log(this.currentNotifications);
    });
  }

}
