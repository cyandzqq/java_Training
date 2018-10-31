import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule , Routes } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { StuLeftComponent } from '../stu-left/stu-left.component';
import { TeaLeftComponent } from '../tea-left/tea-left.component';
import {SelectComponent} from '../select/select.component';
import {BossLeftComponent} from '../boss-left/boss-left.component';
import {ApprovelComponent} from '../approvel/approvel.component';
import {RegisterComponent} from '../register/register.component';
import {RegisterMComponent} from '../register-m/register-m.component';
import {RegisterTComponent} from '../register-t/register-t.component';
import {ApplyComponent} from '../apply/apply.component';
import {FailComponent} from '../fail/fail.component';
const routes: Routes = [
  { path: 'login' , component: LoginComponent } ,
  { path: 'stu_left' , component: StuLeftComponent ,
    children: [{path : 'select' , component : SelectComponent },
      {path:'apply', component: ApplyComponent}
    ]
  },
  { path: 'tea_left' , component: TeaLeftComponent ,
    children: [{path : 'select' , component : SelectComponent },
      {path: 'approve' , component : ApprovelComponent}
    ]
  }, { path: 'dir_left' , component: BossLeftComponent,
    children: [ {path : 'select' , component : SelectComponent },
      {path: 'approve' , component : ApprovelComponent}]
  }, {path: 'register', component: RegisterComponent},
  {path: 'apply', component: ApplyComponent},
  {path: 'register-t', component: RegisterTComponent},
  {path: 'register-m', component: RegisterMComponent},
  {path: 'fail', component: FailComponent}

]
@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: []
})
export class AppRoutingModule { }
