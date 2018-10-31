import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ApplyComponent } from './apply/apply.component';
import { ApprovelComponent } from './approvel/approvel.component';
import { BossLeftComponent } from './boss-left/boss-left.component';
import { FailComponent } from './fail/fail.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RegisterMComponent } from './register-m/register-m.component';
import { RegisterTComponent } from './register-t/register-t.component';
import { SelectComponent } from './select/select.component';
import { StuLeftComponent } from './stu-left/stu-left.component';
import { TeaLeftComponent } from './tea-left/tea-left.component';
import { AppRoutingModule } from './app-routing/app-routing.module';
import  {NgxPaginationModule} from 'ngx-pagination';
import {FormsModule} from '@angular/forms';
import { RouterModule } from '@angular/router';

import { HttpClientModule } from '@angular/common/http';
@NgModule({
  declarations: [
    AppComponent,
    ApplyComponent,
    ApprovelComponent,
    BossLeftComponent,
    FailComponent,
    LoginComponent,
    RegisterComponent,
    RegisterMComponent,
    RegisterTComponent,
    SelectComponent,
    StuLeftComponent,
    TeaLeftComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
