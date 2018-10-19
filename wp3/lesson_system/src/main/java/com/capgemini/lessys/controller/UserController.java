package com.capgemini.lessys.controller;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.lessys.bean.Apply;
import com.capgemini.lessys.bean.Lesson;
import com.capgemini.lessys.bean.User;
import com.capgemini.lessys.service.ApplyService;
import com.capgemini.lessys.service.ScheduleService;
import com.capgemini.lessys.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userservice;
	@Autowired
	ScheduleService scheduleservice;
	@Autowired
	ApplyService applyservice;
	
	//跳转到登录页面
	@RequestMapping(value="login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//mv.addObject("students", list);
		mv.setViewName("login");
		return mv;
	}
	
	//尝试登录
	@RequestMapping(value="trylogin")
	public ModelAndView tryLogin(HttpServletRequest request,HttpServletResponse response){
		String address=request.getParameter("address");	
		String password=request.getParameter("password");		
		User user=userservice.ensure(address, password);
		if(user!=null){	
			int status=user.getStatus();
			if(status==1){
				ModelAndView mv = new ModelAndView();
				mv.addObject("user", user);	
				mv.addObject("lessons", scheduleservice.getAllLesson());
				mv.addObject("masters", userservice.getMaster());
				mv.addObject("count",applyservice.getcount() );
				mv.setViewName("submit_lookfor");
				return mv;
			}else if(status==2||status==3){
				ModelAndView mv = new ModelAndView();
				if(status==2){
					List<Apply> list= applyservice.getApplyByTeacherId(user.getId());
					mv.addObject("slows", list);
				}
				if(status==3){
					List<Apply> list= applyservice.getApplyByMasterId(user.getId());
					System.out.println(list);
					mv.addObject("slows", list);
				}
				mv.addObject("user", user);	
				mv.setViewName("slow_lookfor");
				return mv;
			}else {
				ModelAndView mv = new ModelAndView();
				mv.setViewName("login_fail");
				return mv;
			}		
		}else{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("login_fail");
			System.out.println("空值");
			return mv;
		}	
	}
	
	//跳转到注册页面
	@RequestMapping(value="register")
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//mv.addObject("students", list);
		mv.setViewName("register");
		return mv;
	}
	
	//尝试注册
	@RequestMapping(value="tryregister")
	public ModelAndView tryregister(HttpServletRequest request,HttpServletResponse response){
		String role=request.getParameter("role");	
		String username=request.getParameter("username");
		String address=request.getParameter("address");
		String password=request.getParameter("password");
		if(username==null||username==""||address==null||address==""||password==null||password==""){
			ModelAndView mv = new ModelAndView();	
			mv.setViewName("register_fail");
			System.out.println("填写框不得为空!");
			return mv;
		}
		if(role.equals("student")){			
			int stu=userservice.addUser(new User(username, password, address, 1),0);
			if(stu==1){
				ModelAndView mv = new ModelAndView();
				mv.setViewName("login");
				return mv;
			}else{
				ModelAndView mv = new ModelAndView();	
				mv.setViewName("register_fail");
				return mv;
			}
		}
		else if(role.equals("teacher")){
			String subject=request.getParameter("subject");
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(subject);
			if( !isNum.matches() ){
				ModelAndView mv = new ModelAndView();	
				mv.setViewName("register_fail");
				System.out.println("课程id必须是数字!");
				return mv;
			}else{
				int sub=Integer.parseInt(subject);
				Lesson lesson=scheduleservice.getLessonById(sub);
				if(lesson!=null){
				int use=userservice.addUser(new User(username, password, address, 2),sub);
				if(use==1){
					ModelAndView mv = new ModelAndView();	
					mv.setViewName("login");
					return mv;
				}else{
					ModelAndView mv = new ModelAndView();	
					mv.setViewName("register_fail");
					return mv;
				     }
				}else{
					ModelAndView mv = new ModelAndView();	
					mv.setViewName("register_fail");
					System.out.println("课程不存在!");
					return mv;
				}
			}
			
			
		}
		else if(role.equals("master")){
			int mas=userservice.addUser(new User(username, password, address, 3),0);
			if(mas==1){
				ModelAndView mv = new ModelAndView();	
				mv.setViewName("login");
				return mv;
			}else{
				ModelAndView mv = new ModelAndView();	
				mv.setViewName("register_fail");
				return mv;
			}
        }
		else{
			ModelAndView mv = new ModelAndView();	
			mv.setViewName("register_fail");
			return mv;
		}
	}
	
	
}
