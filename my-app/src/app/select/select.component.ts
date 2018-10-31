import { Component, OnInit } from '@angular/core';
import {HttpClient,HttpParams} from '@angular/common/http';
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
  timesubmit: any;
  submit: string;
  stateOne: number;
  stateTwo: number;
}

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})

export class SelectComponent implements OnInit {
  Applys = [];
  p = 1 ;
  selectList =
    {
      studentName: '',
      studentId : '',
      className : '',
      teacherName: '',
      bossName : ''
    }
  constructor(private http: HttpClient) { }

  ngOnInit() {
  }
  chaxun() {
    this.http.put('http://localhost:8080/count', { } ,  {
      params : new HttpParams().set('token',sessionStorage.getItem('token'))
    }).subscribe((data:number) => {
      if(data==-1){console.log('请先登录');return 0;}
      else{ this.http.put('http://localhost:8080/studentlookfor', { } ,  {
        params : new HttpParams().set('stuName', this.selectList.studentName).set('stuId', this.selectList.studentId).set('lesName', this.selectList.className)
        .set('teaName', this.selectList.teacherName) .set('masName', this.selectList.bossName)
      }).subscribe((data: Apply[]) => {
        this.Applys=data;
      });}
    });
   
    this.selectList = {
      studentName: '',
      studentId: '',
      className: '',
      teacherName: '',
      bossName: ''
    };
  }
}
