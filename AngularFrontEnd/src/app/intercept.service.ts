import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
import { HttpEvent } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class InterceptService implements HttpInterceptor
{
  private auth64 = btoa("my-trusted-client:secret");
  intercept(req, next) {
      console.log(localStorage.getItem('token'));
      let tokenreq = req.clone({
        setHeaders: {
          'Authorization': `Bearer ${localStorage.getItem('token')}`,
          // 'Content-Type':  'application/json',
          //Authorization: `Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzaHUiLCJzY29wZXMiOiJbUk9MRV9VU0VSXSIsImlhdCI6MTU3MDY0MDY4OCwiZXhwIjoxNTcwODU2Njg4fQ.I4XjYgU901rj6wvCj5sud37oTTf-wvVrRNz_oV9cdBA`,
        },
      });
      return next.handle(tokenreq);
    
  }
  constructor() { }
}
