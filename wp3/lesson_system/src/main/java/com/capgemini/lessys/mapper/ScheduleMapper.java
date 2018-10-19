package com.capgemini.lessys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.capgemini.lessys.bean.Lesson;
import com.capgemini.lessys.bean.Schedule;
import com.capgemini.lessys.bean.User;

@Mapper
public interface ScheduleMapper {

	void addSchedule(Schedule sch);//添加老师课程安排
	List<Lesson> getAllLesson();//获取所有的课程
	Lesson getLessonById(int id);//根据id获取课程
	List<User> getTeacherByLesId(int id);//根据课程id查询返回对应的user的list
	
}
