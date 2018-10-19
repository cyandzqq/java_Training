package com.capgemini.lessys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lessys.bean.Apply;
import com.capgemini.lessys.bean.Lesson;
import com.capgemini.lessys.bean.Schedule;
import com.capgemini.lessys.bean.Schedule2;
import com.capgemini.lessys.mapper.ApplyMapper;
import com.capgemini.lessys.mapper.ScheduleMapper;

@Service
public class ScheduleService {

	@Autowired
	ScheduleMapper schedulemapper;
	
	//添加一个课程安排
	public void addSchedule(int teaId,int lesId){
		schedulemapper.addSchedule(new Schedule(teaId, lesId));
	}
	
	//判断课程id是否存在
	public Lesson getLessonById(int id){
		Lesson lesson=schedulemapper.getLessonById(id);
		return lesson;
	}
	
	//获取所有老师课程
	public List<Schedule2> getAllSchedule(){
		List<Schedule2> list=schedulemapper.getAllSchedule();
		return list;
	}
	
	//获取所有课程
	public List<Lesson> getAllLesson(){
		List<Lesson> list=schedulemapper.getAllLesson();
		return list;
	}
	
	
}
