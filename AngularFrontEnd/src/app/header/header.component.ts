import { Component, OnInit } from '@angular/core';
import { ObjectServiceService } from '../Services/object-service.service';
import { User } from '../Models/User';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit {

  public tem: User;

  public signInButtonText: string;
  constructor() { }

  ngOnInit() {
   
  }

}
