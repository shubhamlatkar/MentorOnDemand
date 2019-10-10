import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { UserObj } from '../user/UserObj';

@Injectable({
  providedIn: 'root'
})
export class LogInSignUpService {

  constructor(private http: HttpClient ) { }

  public tem: UserObj = {
    "id": 0,
    "username":"",
    "role":"",
  };

  private sessionObj = new BehaviorSubject(this.tem);
  temObj = this.sessionObj.asObservable();  

  changeData(user: UserObj) {
    this.sessionObj.next(user);
  }

  private userObject : UserObj;
  getAuthentication(userObj): Observable<UserObj> {
    return this.http.post<UserObj>("http://localhost:8080/login", userObj); 
  }

  register(userObj) {
    this.http.post("http://localhost:8080/register", userObj).subscribe();
  }
}
