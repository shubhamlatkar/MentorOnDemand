import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Users } from './Users';
import { Trainings } from './trainings';

@Injectable({
  providedIn: 'root'
})

export class ObjectServiceService {
  constructor(private http: HttpClient) { } 

  private _url: string = "http://localhost:8080/training/get";
  

  public tem: Trainings = {
    "id": 0,
    "name": "",
    "mentorId": 0,
    "mentorName": "",
    "skills":[{
        "id":0,
        "name":"",
    }],
    "completed":false
  };

  private sessionObj = new BehaviorSubject(this.tem);
  temObj = this.sessionObj.asObservable();  

  changeData(user: Trainings) {
    this.sessionObj.next(user);
  }

  getUsers(): Observable<Trainings[]> {
      // console.log(this.http.get<Trainings[]>(this._url));
      return this.http.get<Trainings[]>(this._url);
  }

}
