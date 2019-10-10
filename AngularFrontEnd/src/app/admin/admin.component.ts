import { Component, OnInit } from '@angular/core';
import { User } from '../Models/User';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  trainerUser: number;
  public names : User[];
  public user: User;
  openend: boolean = false;
  searchTerm: string;

  constructor() { }

  ngOnInit() {
    
}

}
