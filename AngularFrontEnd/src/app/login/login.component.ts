import { Component, OnInit, ɵConsole } from '@angular/core';
import { ObjectServiceService } from '../object-service.service';
import { Router } from '@angular/router';
import { Users } from '../Users';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserObj } from '../user/UserObj';
import { LogInSignUpService } from '../log-in-sign-up.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  
  public tokenObj  = {
    "token":""
  };
  public role = {
    "text":""
  }

  constructor(private _objService: ObjectServiceService, private route: Router, private http: HttpClient, private _loginService:LogInSignUpService) { }

  ngOnInit() {
  }
  private userObject:UserObj ;
  private isLoggedIn :boolean;
  onLogIn(formObject) {
    var userObj = {
      "username":formObject.username,
      "password":formObject.password
    }
    // this.http.post("http://localhost:8080/login", userObj).subscribe(data => {
    //   //  this.tokenObj = <any>data.valueOf();
    //   // localStorage.setItem('token', this.tokenObj.token);
    //   this.isLoggedIn = <any>data.valueOf();
    //   console.log(this.isLoggedIn);
    //         this.http.get(`http://localhost:8080/getUserObj/${formObject.username}`).subscribe(data => {
    //     this.userObj = <any>data.valueOf();
    //     // console.log(this.userObj);
    //   });
    // });
    
    this.isLoggedIn = <any>this._loginService.getAuthentication(userObj).subscribe();
    console.log(this.isLoggedIn);
    this.route.navigateByUrl("/dashboard");
  }

  onSignUp(formObject) {
    var userObj = {
      "id":2,
      "username": formObject.username,
      "password":formObject.password,
      "roleId":1
    }
    console.log(userObj);
  //   let headers = new HttpHeaders({
  //     'Content-Type': 'application/json'});
  // let options = { headers: headers };
    this.http.post("http://localhost:8080/register", userObj).subscribe();

  }
}
