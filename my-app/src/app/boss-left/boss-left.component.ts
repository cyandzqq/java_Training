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
  selector: 'app-boss-left',
  templateUrl: './boss-left.component.html',
  styleUrls: ['./boss-left.component.css']
})
export class BossLeftComponent implements OnInit {
  email='';
  id=null;
  constructor(private  router: Router,private http:HttpClient,private activedRouter:ActivatedRoute) { }

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
    this.router.navigateByUrl('dir_left/select');
  }
  approve() {
    this.router.navigate(['dir_left/approve'],{queryParams:{'id':this.id}});
  }
}
