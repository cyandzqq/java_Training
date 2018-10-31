import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {HttpClient, HttpParams} from '@angular/common/http';
import {MyserviceService} from '../myservice.service';
export interface map1{
  token:string;
  status:string;
}
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isActive=''
  id=null;
  loginlist = {
    password: '',
    user: ''
  };
  fhlist = {
    fhz : null
  };
  constructor(private router: Router, private http: HttpClient,private myservice:MyserviceService) { }

  ngOnInit() {
  }
  jump() {
     this.http.put('http://localhost:8080/login', {} ,
    {
      params : new HttpParams().set('address', this.loginlist.user).set('password', this.loginlist.password)
    }).subscribe((data: map1) => {
      sessionStorage.setItem('token',data.token);
       if (data.status === '1') {
         this.router.navigate(['stu_left'],{queryParams:{'email':this.loginlist.user}});
         console.log('学生登入');
       }
       else if (data.status === '2') {
        this.router.navigate(['tea_left'],{queryParams:{'email':this.loginlist.user}});
         console.log('老师登入');
       }
       else if (data.status === '3') {
        this.router.navigate(['dir_left'],{queryParams:{'email':this.loginlist.user}});
         console.log('主任登入');
       } else  {
         console.log(data);
         this.isActive='show'
       }
    });

  }
  register() {
    this.router.navigateByUrl('register');
  }
  returnlogin(){
   this.isActive=''
  }
}
