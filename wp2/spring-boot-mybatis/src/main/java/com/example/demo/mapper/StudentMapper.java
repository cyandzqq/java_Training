package com.example.demo.mapper;


import java.util.ArrayList;
import java.util.List;
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
	List<Student> selectAll();
	ArrayList<Student> findbyclassid(int id);
	List<Student> selectstudentbymap(Map<String,Object> map);
	int selectclassidbyid(int id);
}
