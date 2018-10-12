package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.Address;
import com.example.demo.bean.Student;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.mapper.StudentMapper;

@Controller
public class StudentConntroller {

	@Autowired
	StudentMapper studentmapper;
	@Autowired
	AddressMapper addressmapper;
	@Autowired
	ClassMapper classmapper;
	
	/*@RequestMapping(value="getstudent")
	public Student getStudent(int id){
		return studentmapper.selectstudent(id);
	}*/
	
	@RequestMapping(value="getStudent")
	public ModelAndView getStudent(HttpServletRequest request,HttpServletResponse response){
		request.getParameter("id");
		List<Student> list= studentmapper.selectAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("students", list);
		mv.setViewName("student");
		return mv;
	}
	
	@RequestMapping(value="selectStudentbymap")
	public ModelAndView selectStudentbymap(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		String age=request.getParameter("age");		
		String claid=request.getParameter("cla");	
		Map<String, Object> map=new HashMap<>();
		if(name!=null&&name!=""){map.put("name", name);}
		if(age!=null&&age!=""){int agee=Integer.parseInt(age);map.put("age", agee);}
		if(claid!=null&&claid!=""){int claa=Integer.parseInt(claid);map.put("classId", claa);}	
		List<Student> list= studentmapper.selectstudentbymap(map);
		ModelAndView mv = new ModelAndView();
		mv.addObject("students", list);
		mv.setViewName("student");
		return mv;
	}
	
	@RequestMapping(value="deleteStudent")
	public ModelAndView deletestudent(int id,HttpServletRequest request,HttpServletResponse response){
		studentmapper.deletestudent(id);
		request.getParameter("id");
		List<Student> list= studentmapper.selectAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("students", list);
		mv.setViewName("student");
		return mv;
	}
	
	@RequestMapping(value="updateStudent0")
	public ModelAndView updatestudent0(int id,HttpServletRequest request,HttpServletResponse response){
		request.getParameter("id");
		ModelAndView mv = new ModelAndView();
		mv.addObject("stuid", id);
		mv.setViewName("updatestudent");
		return mv;
	}
	
	@RequestMapping(value="updateStudent")
	public ModelAndView updatestudent(int id,HttpServletRequest request,HttpServletResponse response){
		Student newstu=new Student();
		newstu.setStuId(id);
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		int agee=Integer.parseInt(age);
		String claid=request.getParameter("cla");
		int claa=Integer.parseInt(claid);
		newstu.setStuName(name);
		newstu.setStuAge(agee);
		newstu.setClaId(claa);
		newstu.setAddress(addressmapper.selectaddress(id));
		studentmapper.updatestudent(newstu);
		List<Student> list= studentmapper.selectAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("students", list);
		mv.setViewName("student");
		return mv;
	}
	
	@RequestMapping(value="addstudent")
	public void addStudent(Student stu){
		studentmapper.addstudent(stu);
	}
}
