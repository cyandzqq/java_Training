import { Component, OnInit } from '@angular/core';
import {ActivatedRoute,Router, Params} from '@angular/router';
import {MyserviceService} from '../myservice.service';
import {HttpClient, HttpParams,HttpHeaders} from '@angular/common/http';
export interface User {
  name: string ;
  id: number ;
  password: string;
  email: string;
  status: number;
}
@Component({
  selector: 'app-stu-left',
  templateUrl: './stu-left.component.html',
  styleUrls: ['./stu-left.component.css']
})
export class StuLeftComponent implements OnInit {
  name='';
  id=null;
  email='';
  isActive = '';
  constructor(private router: Router, private activedRouter : ActivatedRoute,private myservice:MyserviceService,private http:HttpClient) { }
  
  ngOnInit() {
    this.activedRouter.queryParams.subscribe((params:Params)=>{
      this.email=params['email']
     });
     this.http.put('http://localhost:8080/getUerByEmail', 
     { } , 
      { params : new HttpParams().set('token',sessionStorage.getItem('token'))
   }).subscribe((data:User) => {
     if(data!=null){
      this.id=data.id;
      this.name=data.name;
     } else{console.log('请先登录')}
    
   });
  }
  select() {
    this.router.navigateByUrl('stu_left/select');
  }
  apply(){
    this.router.navigate(['stu_left/apply'],{queryParams:{'id':this.id,'name':this.name}});
  }
}
