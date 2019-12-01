import { Component, OnInit } from '@angular/core';
import { ObjectServiceService } from '../object-service.service';
import { Trainings } from '../trainings';
import { HttpClient } from '@angular/common/http';
import { Users } from '../Users';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit {

    onClick(event: any) {
        this.searchTerm = event.target.innerText;
        this.searchTerm = this.searchTerm.trim();
    }
    public names : Trainings[];
    public user: Users = {
      "id": 1,
    "name": "",
    "occ": "",
    "univ": "",
    "exp": "",
    "role": 2,
    "expertArea": ""
    };
    trainerOptions: string = 'currentTraining';
    openend: boolean = false;
    searchTerm: string;
  constructor(private _objService: ObjectServiceService, private http: HttpClient) {
    this.http.get("http://localhost:8080/getRole/shu").subscribe(data => {
      console.log(data);
    });
  }
  
  ngOnInit() {
    this._objService.getUsers().subscribe(data => {
        this.names = data; 
    });
    // this._objService.temObj.subscribe(data => this.user = data);
  }
  regsiter() {

  }

  getDetails(event) {
    console.log(event);
  } 
}
