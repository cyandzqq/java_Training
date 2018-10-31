import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient, HttpParams} from '@angular/common/http';
@Component({
  selector: 'app-register-m',
  templateUrl: './register-m.component.html',
  styleUrls: ['./register-m.component.css']
})
export class RegisterMComponent implements OnInit {
  isActive=''
  masRegister = {
    name: '',
    email: '',
    password: ''
  };
  constructor(private router: Router,private http:HttpClient) { }

  ngOnInit() {
  }
  stuBox() {
    this.router.navigateByUrl('register');
  }
  teaBox() {
    this.router.navigateByUrl('register-t');
  }
  masBox() {
    this.router.navigateByUrl('register-m');
  }
  reg() {
    
    this.http.put('http://localhost:8080/register', { } ,  {
      params : new HttpParams().set('name', this.masRegister.name).set('password', this.masRegister.password).set('email',this.masRegister.email).set('role','master')
    }).subscribe((data: number) => {
      console.log(data);
       if(data===1){
        this.router.navigateByUrl('login');
        console.log('注册失败');
       }else{
        this.masRegister = {
          name: '',
          email: '',
          password: ''
        };
        this.isActive='show'
        console.log('注册失败');
       }
    });
  }
  returnlogin(){
    this.isActive='';
  }
}
