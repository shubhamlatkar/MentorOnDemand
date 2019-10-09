import { Component, OnInit } from '@angular/core';
import { ObjectServiceService } from '../object-service.service';
import { Users } from '../Users';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  trainerUser: number;
  public names : Users[];
  public user: Users;
  openend: boolean = false;
  searchTerm: string;

  constructor() { }

  ngOnInit() {
    
}

}
