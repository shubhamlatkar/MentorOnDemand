import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { HeaderComponent } from './header/header.component';
import { NgxPopper } from 'angular-popper';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';
import { TrainerFilterPipe } from './trainer-filter.pipe';
import { FormsModule }    from '@angular/forms';
import { MatToolbarModule, MatIconModule, MatSidenavModule, MatListModule, MatButtonModule } from  '@angular/material';
import { AdminComponent } from './admin/admin.component';
import { TrainerComponent } from './trainer/trainer.component';
import { UserComponent } from './user/user.component';
import { ObjectServiceService } from './object-service.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'; 
import { InterceptService } from './intercept.service';

const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DashboardComponent,
    FooterComponent,
    LoginComponent,
    TrainerFilterPipe,
    AdminComponent,
    TrainerComponent,
    UserComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
    ),
    BrowserModule,
    AppRoutingModule,
    AngularFontAwesomeModule,
    NgxPopper,
    NgxPaginationModule, 
    FormsModule,
        HttpClientModule 
  ],
  
  providers: [ObjectServiceService, {
    provide:HTTP_INTERCEPTORS,
    useClass:InterceptService,
    multi:true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
