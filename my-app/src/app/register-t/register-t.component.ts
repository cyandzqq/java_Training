import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient, HttpParams} from '@angular/common/http';
export interface Lesson {
  id: number;
  name: string;
}
@Component({
  selector: 'app-register-t',
  templateUrl: './register-t.component.html',
  styleUrls: ['./register-t.component.css']
})
export class RegisterTComponent implements OnInit {
  isActive=''
  lessons={
    id: null,
    name:''
  }
  lessonlist=[];
  teaRegister = {
    name: '',
    email: '',
    password: '',
    lesson: null,
  };
  constructor(private router: Router,private http:HttpClient) { }

  ngOnInit() {
    this.http.put('http://localhost:8080/getlessons', { } ,  {
       }).subscribe((data:Lesson[]) => {        
        this.lessonlist=data;
       });
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
      params : new HttpParams().set('name', this.teaRegister.name).set('password', this.teaRegister.password)
      .set('email',this.teaRegister.email).set('role','teacher').set('lesId',this.teaRegister.lesson)
    }).subscribe((data: number) => {
       if(data===1){
        this.router.navigateByUrl('login');
        console.log('注册失败');
       }else{
        this.teaRegister = {
          name: '',
          email: '',
          password: '',
          lesson: '',
        };
        this.isActive='show';
        console.log('注册失败');
       }
    });
  }
  returnlogin(){
    this.isActive='';
  }
}
