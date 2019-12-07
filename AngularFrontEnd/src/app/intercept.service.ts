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
    let tokenreq = req.clone({
      setHeaders: {
        // 'Authorization': `Bearer ${localStorage.getItem('token')}`,
        // 'Content-Type':  'application/json',
        // 'Authorization': `Basic ${ this.auth64 }`,
      },
    });
    return next.handle(tokenreq);
  }
  constructor() { }
}
