import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from './user.service';
import { User } from 'src/app/Models/User';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TrainerService {

  constructor(private http: HttpClient) { }

  getTrainers() : Observable<User[]> {
    return this.http.get<User[]>("http;//localhost:8080/getAllTrainers");
  }
}
