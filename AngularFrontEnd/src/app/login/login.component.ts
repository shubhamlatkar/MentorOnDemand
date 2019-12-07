import { Component, OnInit, ɵConsole } from '@angular/core';
import { ObjectServiceService } from '../Services/object-service.service';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserObj } from '../user/UserObj';
import { LogInSignUpService } from '../Services/log-in-sign-up.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  
  public tokenObj  = {
    "token":""
  };
  constructor(private _objService: ObjectServiceService, private route: Router, private http: HttpClient, private _loginService:LogInSignUpService) { }

  ngOnInit() {
  }

  private userObject:UserObj ;

  onLogIn(formObject) {
    var userObj = {
      "username":formObject.username,
      "password":formObject.password
    }
    this._loginService.getAuthentication(userObj).subscribe(data => {
      this.userObject =<any>data;
      this._loginService.changeData(this.userObject);      
    });
    this.route.navigateByUrl("/dashboard");
  }

  onSignUp(formObject) {
    var userObj = {
      "id":3,
      "username": formObject.username,
      "password":formObject.password,
      "roleId":2
    }
    this._loginService.register(userObj);
  }
}
