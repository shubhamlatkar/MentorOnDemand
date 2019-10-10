import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Training } from 'src/app/Models/Training';
import { Cources } from '../Models/Cources';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {

  constructor(private http: HttpClient) { }

  getAllTrainings() : Observable<Training> {
    return this.http.get<Training>("http://localhost:8084/getAllTrainings");
  }

  getCources(): Observable<Cources[]> {
    return this.http.get<Cources[]>("http://localhost:8084/getCources");
  }
}
