import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserObj } from './user/UserObj';

@Injectable({
  providedIn: 'root'
})
export class LogInSignUpService {

  constructor( private http: HttpClient ) { }
  private userObject : UserObj;
  getAuthentication(userObj): Observable<boolean> {
    return this.http.post<boolean>("http://localhost:8080/token/generate-token", userObj); 
  }
}
