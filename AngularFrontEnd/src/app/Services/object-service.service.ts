import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Trainings } from '../trainings';
import { Training } from 'src/app/Models/Training';

@Injectable({
  providedIn: 'root'
})

export class ObjectServiceService {
  constructor(private http: HttpClient) { } 

  private _url: string = "http://localhost:8080/training/get";

  getTrainings(): Observable<Training[]> {
      return this.http.get<Training[]>(this._url);
  }

}
