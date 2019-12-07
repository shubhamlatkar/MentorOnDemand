import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Payment } from 'src/app/Models/Payment';
import { Notifications } from 'src/app/Models/Notifications';
import { User } from '../Models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getNotificationsById(id): Observable<Notifications> {
    return this.http.get<Notifications>(`http://localhost:8081/getNotificationsById/${id}`);
  }
  getPayments() : Observable<Payment> {
    return this.http.get<Payment>("http://localhost:8081/getPayments");
  }
  
  getUser(id): Observable<User> {
    return this.http.get<User>(`http://localhost:8081/getUserById/${id}`);
  }
}
