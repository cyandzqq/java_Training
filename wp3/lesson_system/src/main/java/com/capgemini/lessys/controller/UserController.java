package com.capgemini.lessys.controller;


import java.awt.Window;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Servlet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import com.capgemini.lessys.bean.Apply;
import com.capgemini.lessys.bean.JavaWebToken;
import com.capgemini.lessys.bean.Lesson;
import com.capgemini.lessys.bean.User;
import com.capgemini.lessys.service.ApplyService;
import com.capgemini.lessys.service.ScheduleService;
import com.capgemini.lessys.service.UserService;

@Controller
public class UserController{

	@Autowired
	UserService userservice;
	@Autowired
	ScheduleService scheduleservice;
	@Autowired
	ApplyService applyservice;
	
	/*//跳转到登录页面
		@RequestMapping(value="index")
		public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
			ModelAndView mv = new ModelAndView();
			mv.setViewName("firstPage");
			return mv;
		}*/
	
	/*//跳转到登录页面
	@RequestMapping(value="login")
	@ResponseBody
	public  User login(HttpServletRequest request){				
		System.out.println(request.getParameter("phone"));
	    return userservice.getUserById(1);
	}*/
	
	//尝试登录
	@RequestMapping(value="login")
	@ResponseBody
	public Map<String,String> login(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		Map<String,String> map=new HashMap<>();
		String address=request.getParameter("address");	
		String password=request.getParameter("password");		
		User user=userservice.ensure(address, password);
		if(user!=null){	
			String token = JavaWebToken.sign(user, 30L * 24L * 3600L * 1000L);
			session.setAttribute("token", token);
			System.out.println(session.getAttribute("token"));
			map.put("token", token);
			int status=user.getStatus();			
			if(status==1){
				map.put("status", "1");
				return map;
			}else if(status==2){
				map.put("status", "2");
				return map;				
			}else if(status==3){
				map.put("status", "3");
				return map;
			}else{
				return null;
			}		
		}else {
				return null;
			}		
	}
	
	/*//跳转到注册页面
	@RequestMapping(value="register")
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//mv.addObject("students", list);
		mv.setViewName("register");
		return mv;
	}*/
	
	//尝试注册
	@RequestMapping(value="register")
	@ResponseBody
	public int register(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");	
		String password=request.getParameter("password");
		String address=request.getParameter("email");
		String role=request.getParameter("role");
		System.out.println(name+password+address+role);
		if(name==null||name==""||address==null||address==""||password==null||password==""||role==null||role==""){
			return 0;
		}
		if(role.equals("student")||role.equals("master")){			
			int stu=userservice.addUser(new User(name, password, address, 1),0);
			if(stu==1){
				return 1;
			}else{
				return 0;
			}
		}else if(role.equals("teacher")){
			String subject=request.getParameter("lesId");
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(subject);
			if( !isNum.matches() ){
				return 0;
			}else{
				int sub=Integer.parseInt(subject);
				Lesson lesson=scheduleservice.getLessonById(sub);
				if(lesson!=null){
				int use=userservice.addUser(new User(name, password, address, 2),sub);
				if(use==1){
					return 1;
				}else{
					return 0;
				     }
				}else{
					System.out.println("课程不存在!");
					return 0;
				}
			}
		}else{return 0;}
	}
	
	@RequestMapping(value="getUerByEmail")
	@ResponseBody
	public User getUerByEmail(HttpServletRequest request,HttpServletResponse response, HttpSession session){
		
		String token=request.getParameter("token");
		User user=JavaWebToken.unsign(token,User.class);
		System.out.println(user);
		if(user==null){return null;}
		String email=user.getEmail();
		String password=user.getPassword();
		User user1=userservice.ensure(email, password);
		if(user1!=null){return user;}
		else{return null;}
		
	}
			
	
}
