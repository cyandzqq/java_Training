package com.capgemini.lessys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.capgemini.lessys.bean.User;

@Mapper
public interface UserMapper {

	void addUser(User user);//添加用户
	User getUserByEmail(@Param("email")String email);//根据email(即账号)来获取用户的实体类
	List<User> getMaster();//获取包含所有主任(即status为3的user)的集合
	List<User> getTeacherByLessonId(int id);//根据课程id获取负责该课程的所有老师的的用户实体类集合
	User getUserById(@Param("id")int id);//通过用户id获取具体的一个user实体
	
}
