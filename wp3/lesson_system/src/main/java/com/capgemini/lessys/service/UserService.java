package com.capgemini.lessys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lessys.bean.Lesson;
import com.capgemini.lessys.bean.Schedule;
import com.capgemini.lessys.bean.User;
import com.capgemini.lessys.mapper.ScheduleMapper;
import com.capgemini.lessys.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper usermapper;
	@Autowired
	ScheduleMapper schedulemapper;
	
	//注册按钮功能
	//根据不同身份对用户进行添加入库
	public int addUser(User user,int id){
		User uu= usermapper.getUserByEmail(user.getEmail());
		if(uu!=null){
			System.out.println("用户名存在");
			return 0;
		}
		int state=user.getStatus();
		if(state==1){
			usermapper.addUser(user);
			System.out.println("学生添加成功!");
			return 1;
		}
		if(state==2){
			usermapper.addUser(user);
			User u=usermapper.getUserByEmail(user.getEmail());
			schedulemapper.addSchedule(new Schedule(u.getId(),id));
			System.out.println("老师添加成功!");
			return 1;
		}
		if(state==3){
			usermapper.addUser(user);
			System.out.println("教导主任添加成功!");
			return 1;
		}
		return 0;
	}	
	
	//邮箱和密码匹配判断 匹配返回true 不匹配返回false
	public User ensure(String email,String password){
		if(email==null||email==""||password==null||password==""){
			return null;
		}	
		User user =usermapper.getUserByEmail(email);
		if(user.getPassword().equals(password)){
			return user;
		}else{return null;}
	}
	
	//获取教导主任的User集合
	public List<User> getMaster(){
		List<User> list=usermapper.getMaster();
		return list;
	}
	
	//根据课程id获取所有的老师的集合
	public List<User> getTeacherByLesId(int id){
		 List<User> list=usermapper.getTeacherByLessonId(id);
		 return list;
	}
	
	//根据id找到相应的用户
	public User getUserById(int id){
		User user=usermapper.getUserById(id);
		return user;
	}
	
}
