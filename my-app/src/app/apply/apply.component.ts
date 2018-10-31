import { Component, OnInit } from '@angular/core';
import {HttpClient,HttpParams} from '@angular/common/http';
import {FormGroup, FormControl, Validators, ReactiveFormsModule} from '@angular/forms';
import {ActivatedRoute,Router, Params}from '@angular/router';
import {MyserviceService} from '../myservice.service';
export interface User {
  name: string ;
  id: number ;
  password: string;
  email: string;
  status: number;
}

export interface Lesson {
  id: number;
  name: string;
  tealist:[User]
}
@Component({
  selector: 'app-apply',
  templateUrl: './apply.component.html',
  styleUrls: ['./apply.component.css']
})

export class ApplyComponent implements OnInit {
  isActive = ''
  listT=[];
  count=0;
  listDate = [];
  listLesson =[];
  listMaster=[];
  listApply = {
    name:'',
    lesid: null,
    teaid: null,
    masid: null,
    student_id: '',
    class: '',
    email: '',
    phone: ''
  };
  constructor(private http: HttpClient,private activedRouter:ActivatedRoute,private myservice:MyserviceService) { }

  ngOnInit() {
    this.activedRouter.queryParams.subscribe((params:Params)=>{
    this.listApply.student_id=params['id'];
    this.listApply.name=params['name'];
     });

     this.http.put('http://localhost:8080/count', { } ,  {
      params : new HttpParams().set('token',sessionStorage.getItem('token'))
    }).subscribe((data:number) => {
      if(data==-1){console.log('请先登录');return 0;}
     this.count=data;
     this.count++;
     this.count++;
    });
     
      this.http.put('http://localhost:8080/getlessons', { } , 
       {
       }).subscribe((data:Lesson[]) => {        
        this.listLesson=data;
       });

      this.http.put('http://localhost:8080/getmasters', { } ,  {
      }).subscribe((data:User[]) => {
       this.listMaster=data;
      });
     }
     tosubmit(){
       this.isActive='show'
     }
     submit(){
      this.http.put('http://localhost:8080/apply', { } ,  {
        params : new HttpParams().set('id', this.listApply.student_id).set('lesid', this.listApply.lesid).set('teaid', this.listApply.teaid).set('masid', this.listApply.masid)
        .set('student_id',this.listApply.student_id).set('class', this.listApply.class).set('email', this.listApply.email).set('phone', this.listApply.phone)
      }).subscribe((data:number) => {
        if(data===1){
          console.log('申请成功');
          this.listApply.lesid=null;this.listApply.teaid=null;this.listApply.masid=null;this.listApply.class='';
          this.listApply.email='';this.listApply.phone='';
        }
        else{
          console.log('申请失败');
          this.listApply.lesid=null;this.listApply.teaid=null;this.listApply.masid=null;this.listApply.class='';
          this.listApply.email='';this.listApply.phone='';
        }
      });
      this.isActive=''
    }
    submit2(){
      this.isActive=''
    }
    getOptions(event) {
      for(let i=0;i<this.listLesson.length;i++) {
        if(event == this.listLesson[i].id){
         console.log(this.listLesson[i]); 
         this.listT=this.listLesson[i].tealist;
        }
      }
    }
    }

 
 

