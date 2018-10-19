package com.capgemini.lessys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.capgemini.lessys.bean.User;

@Mapper
public interface UserMapper {

	void addUser(User user);//添加用户
	User getUserByEmail(@Param("email")String email);
	List<User> getMaster();//获取包含所有主任(3)的集合
	List<User> getTeacherByLessonId(int id);
	User getUserById(@Param("id")int id);
}
