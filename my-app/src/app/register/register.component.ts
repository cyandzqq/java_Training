import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {HttpClient, HttpParams} from '@angular/common/http';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form = new FormGroup({
    name: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required])
  });
  model = {
    'name' : 'zhangsan',
    'default': '-请选择-'
  }
  hobbys = ['Read', 'Music', 'Food'];
  isActive0 = '';
  isActive = '';
  isActiveT = '';
  isActiveM = '';
  stuRegister = {
    name: '',
    email: '',
    password: ''
  };
  teaRegister = {
    name: '',
    email: '',
    password: '',
    lesson: '',
  };
  masRegister = {
    name: '',
    email: '',
    password: ''
  };
  name: any;
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
  onSubmit(value) {
    console.log(value);
  }
  reg() {
    console.log(this.masRegister);
    this.http.put('http://localhost:8080/register', { } ,  {
      params : new HttpParams().set('name', this.stuRegister.name).set('password', this.stuRegister.password).set('email',this.stuRegister.email).set('role','student')
    }).subscribe((data: number) => {
      console.log(data);
       if(data===1){
        this.router.navigateByUrl('login');
        console.log('注册成功');
       }else{
        this.stuRegister = {
          name: '',
          email: '',
          password: ''
        }
        this.isActive0='show';
       }
    });
  }
  returnlogin(){
    this.isActive0='';
  }
}
