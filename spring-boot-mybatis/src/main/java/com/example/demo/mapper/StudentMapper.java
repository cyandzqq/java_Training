package com.example.demo.mapper;


import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.example.demo.bean.Student;

@Mapper
public interface StudentMapper {

	void addstudent(Student stu);
	void deletestudent(int id);
	void updatestudent(Student stu);
	Student selectstudent(int id);
	ArrayList<Student> findbyclassid(int id);
	Student selectstudentbymap(Map<String,Object> map);
	int selectclassidbyid(int id);
}
