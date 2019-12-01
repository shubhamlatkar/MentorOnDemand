import { Component, OnInit } from '@angular/core';
import { ObjectServiceService } from '../object-service.service';
import { Users } from '../Users';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit {

  public tem: Users;

  public signInButtonText: string;
  constructor() { }

  ngOnInit() {
   
  }

}
