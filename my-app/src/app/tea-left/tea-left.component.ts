import { Component, OnInit } from '@angular/core';
import {Router,ActivatedRoute,Params} from '@angular/router';
import {HttpClient, HttpParams} from '@angular/common/http';
export interface User {
  name: string ;
  id: number ;
  password: string;
  email: string;
  status: number;
}
@Component({
  selector: 'app-tea-left',
  templateUrl: './tea-left.component.html',
  styleUrls: ['./tea-left.component.css']
})
export class TeaLeftComponent implements OnInit {
  email='';
  id=null;
  isActive = ''
  constructor( private router: Router,private activedRouter:ActivatedRoute,private http:HttpClient ) { }

  ngOnInit() {
    this.activedRouter.queryParams.subscribe((params:Params)=>{
      this.email=params['email']
     });
     this.http.put('http://localhost:8080/getUerByEmail', { } ,  {
     params : new HttpParams().set('email', this.email)
   }).subscribe((data:User) => {
    this.id=data.id;
   });
  }
  select() {
    this.router.navigateByUrl('tea_left/select');
  }
  approve() {
    this.router.navigate(['tea_left/approve'],{queryParams:{'id':this.id}});
  }
}
