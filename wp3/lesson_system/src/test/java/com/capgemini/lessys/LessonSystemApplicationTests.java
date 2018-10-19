package com.capgemini.lessys;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.lessys.bean.Apply;
import com.capgemini.lessys.bean.Lesson;
import com.capgemini.lessys.bean.Schedule;
import com.capgemini.lessys.bean.User;
import com.capgemini.lessys.mapper.ApplyMapper;
import com.capgemini.lessys.mapper.ScheduleMapper;
import com.capgemini.lessys.mapper.UserMapper;
import com.mysql.fabric.xmlrpc.base.Data;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LessonSystemApplicationTests {

	@Autowired
	UserMapper usermapper;
	@Autowired
	ScheduleMapper schedulemapper;
	@Autowired
	ApplyMapper applymapper;
	
	@Test
	public void contextLoads() {
		//this.addUser();
		//this.getAll();
		//this.addSchedule();
		//this.getTeacherByLessonId();
		//this.getMaster();
		//this.addApply();
		//this.setState();
		//this.getApplybymap();
		//this.getApplybystulesid();
		//this.getlesson();
		this.getAllLesson();
	}
	
	public void getAllLesson(){
		System.out.println(schedulemapper.getAllLesson());
	}
	
	
	public void getlesson(){
		
		System.out.println(schedulemapper.getLessonById(2));
	}
	public void getApplybystulesid(){
		Apply apply=applymapper.getApplyByStuLesId(5, 2);
		System.out.println(apply);
	}
	public void getApplybymap(){
		Map<String, Object> map=new HashMap<>();
		map.put("stuName", "student");
		List<Apply> list=applymapper.getApplyByMap(map);
		System.out.println(list);
	}

	public void addUser(){
		User user=new User("大王","12345","213@123.com",2);
		usermapper.addUser(user);
	}
	public void getAll(){
		List<Lesson> list=schedulemapper.getAllLesson();
		System.out.println(list);
	}
	public void addSchedule(){
		Schedule sch=new Schedule(1, 2);
		schedulemapper.addSchedule(sch);
	}
	public void getTeacherByLessonId(){
		List<User> list= schedulemapper.getTeacherByLesId(1);
		System.out.println(list);
	}
	public void getMaster(){
		List<User> list =usermapper.getMaster();
		System.out.println(list);
	}
	public void addApply(){
		Apply apply=new Apply(1, 1, "二班", 2, 1, 1, "17826615719" , "123123@", new Date());
		applymapper.addApply(apply);
	}
	public void setState(){
		applymapper.setStateOne(1, 1);
		applymapper.setStateTwo(1, -1);
	}
}
