import { Component, OnInit } from '@angular/core';
import {ActivatedRoute,Router, Params} from '@angular/router';
import {HttpClient, HttpParams} from '@angular/common/http';
export interface User {
  name: string ;
  id: number ;
  password: string;
  email: string;
  status: number;
}
export interface Apply {
  id: number;
  stuId: number;
  teaId: number;
  masId: number;
  lesId: number;
  stuNum: number;
  grade: string;
  phone: string;
  email: string;
  stuName: string;
  lesName: string;
  teaName: string;
  masName: string;
  stateOne: number;
  stateTwo: number;
}
@Component({
  selector: 'app-approvel',
  templateUrl: './approvel.component.html',
  styleUrls: ['./approvel.component.css']
})
export class ApprovelComponent implements OnInit {
  p = 1;
  index=null;
  ii=null;
  id=null;
  isActive = ''
  isActive1 = ''
  approvelList = []
  constructor(private http:HttpClient,private activedRouter:ActivatedRoute ) { }

  ngOnInit() {
    this.activedRouter.queryParams.subscribe((params:Params)=>{
      this.id=params['id']
     });
    this.http.put('http://localhost:8080/getApplysById', { } ,  {
      params : new HttpParams().set('id', this.id)
    }).subscribe((data: Apply[]) => {
      if(data!=null){
        this.approvelList = data;
      }
    });
  }
  agree(i,index) {
    console.log(i);
    this.http.put('http://localhost:8080/good', { } ,  {
    params : new HttpParams().set('id', this.id).set('appId',i)
  }).subscribe(dta => {
    })
   this.approvelList.splice(index,1);
   this.isActive1='show'
  }
  refuse(i,ind) {
    this.index=ind;
    this.ii=i;
    this.isActive = 'show';
  }
  cancel() {
    this.isActive = '' ;
  }
  reject() {
    this.http.put('http://localhost:8080/bad', { } ,  {
      params : new HttpParams().set('id', this.id).set('appId',this.ii)
    }).subscribe(dta => {
    })
    this.approvelList.splice(this.index,1);
    this.isActive = '' ;
  }
  reject1(){
    this.isActive1=''
  }
}
