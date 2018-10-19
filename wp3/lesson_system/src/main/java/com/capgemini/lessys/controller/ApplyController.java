package com.capgemini.lessys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.lessys.bean.Apply;
import com.capgemini.lessys.bean.User;
import com.capgemini.lessys.service.ApplyService;
import com.capgemini.lessys.service.ScheduleService;
import com.capgemini.lessys.service.UserService;
@Controller
public class ApplyController {

	@Autowired
	UserService userservice;
	@Autowired
	ScheduleService scheduleservice;
	@Autowired
	ApplyService applyservice;
	
	@RequestMapping(value="apply")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		int id=Integer.parseInt(request.getParameter("id"));//学生id		
		int lesid=Integer.parseInt(request.getParameter("lesson"));//课程id
		int teaid=Integer.parseInt(request.getParameter("teacher"));
		int masid=Integer.parseInt(request.getParameter("master"));//主任id
		int stuNum=Integer.parseInt(request.getParameter("student_id"));//学生学号
		String cla=request.getParameter("class");//班级
		String email=request.getParameter("email");//邮件
		String phone=request.getParameter("phone");//手机号码
		Apply myapply=new Apply(id, stuNum, cla, lesid, teaid, masid, phone, email, new Date());
		if(applyservice.getApplyByStuAndLesId(id,lesid)){
		    applyservice.addApply(myapply);
		    System.out.println("添加申请表成功");
			User user=userservice.getUserById(id);	
			ModelAndView mv = new ModelAndView();
			mv.addObject("lessons", scheduleservice.getAllLesson());
			mv.addObject("masters", userservice.getMaster());
			mv.addObject("count",applyservice.getcount() );
			mv.addObject("user", user);
			mv.setViewName("submit_lookfor");			
			return mv;
		}
		else{
        	    System.out.println("添加申请表失败");
        		User user=userservice.getUserById(id);	
        		ModelAndView mv = new ModelAndView();
        		mv.addObject("lessons", scheduleservice.getAllLesson());
        		mv.addObject("masters", userservice.getMaster());
        		mv.addObject("count",applyservice.getcount() );
        		mv.addObject("user", user);
        		mv.setViewName("submit_lookfor");
        		
        		return mv;
	    }
	}
	
	@RequestMapping(value="studentlookfor")
	public ModelAndView lookfor(HttpServletRequest request,HttpServletResponse response){
		int userId=Integer.parseInt(request.getParameter("userId"));
		User user=userservice.getUserById(userId);
		int count=applyservice.getcount();
		String stuName=request.getParameter("stuName");
		String num=request.getParameter("stuNum");
		String lesName=request.getParameter("lesName");
		String teaName=request.getParameter("teaName");
		String masName=request.getParameter("masName");
		Map<String, Object> map=new HashMap<>();
		if(stuName==""&&num==""&&lesName==""&&teaName==""&&masName==""){
			ModelAndView mv = new ModelAndView();
			mv.addObject("user", user);
			mv.addObject("count", count);
			mv.addObject("schedules", scheduleservice.getAllSchedule());
			mv.addObject("lessons", scheduleservice.getAllLesson());
			mv.addObject("masters", userservice.getMaster());
			mv.setViewName("submit_lookfor");
			return mv;
		}
		if(num!=null&&num!=""){
			System.out.println("you i");
			int i=Integer.parseInt(num);
			map.put("stuName",stuName);map.put("stuNum",i );map.put("lesName",lesName );map.put("teaName",teaName );map.put("masName",masName );
			List<Apply> applys=applyservice.getApplyByMap(map);
			ModelAndView mv = new ModelAndView();
			mv.addObject("user", user);
			mv.addObject("count", count);
			mv.addObject("schedules", scheduleservice.getAllSchedule());
			mv.addObject("lessons", scheduleservice.getAllLesson());
			mv.addObject("masters", userservice.getMaster());
			mv.addObject("applys", applys);
			mv.setViewName("submit_lookfor");
			return mv;
		}else{
			System.out.println("no i");
			map.put("stuName",stuName);map.put("lesName",lesName );map.put("teaName",teaName );map.put("masName",masName );
			List<Apply> applys=applyservice.getApplyByMap(map);
			System.out.println(applys);
			ModelAndView mv = new ModelAndView();
			mv.addObject("user", user);
			mv.addObject("count", count);
			mv.addObject("schedules", scheduleservice.getAllSchedule());
			mv.addObject("lessons", scheduleservice.getAllLesson());
			mv.addObject("masters", userservice.getMaster());
			mv.addObject("applys", applys);
			mv.setViewName("submit_lookfor");
			return mv;
		}
		
	}
	
	@RequestMapping(value="teacherlookfor")
	public ModelAndView lookfor2(HttpServletRequest request,HttpServletResponse response){
		int userId=Integer.parseInt(request.getParameter("userId"));
		User user=userservice.getUserById(userId);
		int status=user.getStatus();
		String stuName=request.getParameter("stuName");
		String num=request.getParameter("stuNum");
		String lesName=request.getParameter("lesName");
		String teaName=request.getParameter("teaName");
		String masName=request.getParameter("masName");
		Map<String, Object> map=new HashMap<>();
		if(stuName==""&&num==""&&lesName==""&&teaName==""&&masName==""){
			ModelAndView mv = new ModelAndView();
			mv.addObject("user", user);
			if(status==2){
				List<Apply> list= applyservice.getApplyByTeacherId(user.getId());
				mv.addObject("slows", list);
			}
			if(status==3){
				List<Apply> list= applyservice.getApplyByMasterId(user.getId());
				mv.addObject("slows", list);
			}
			mv.setViewName("slow_lookfor");
			return mv;
		}
		if(num!=null&&num!=""){		
			int i=Integer.parseInt(num);
			map.put("stuName",stuName);map.put("stuNum",i );map.put("lesName",lesName );map.put("teaName",teaName );map.put("masName",masName );
			List<Apply> applys=applyservice.getApplyByMap(map);			
			ModelAndView mv = new ModelAndView();
			mv.addObject("user", user);
			mv.addObject("applys", applys);
			if(status==2){
				List<Apply> list= applyservice.getApplyByTeacherId(user.getId());
				mv.addObject("slows", list);
			}
			if(status==3){
				List<Apply> list= applyservice.getApplyByMasterId(user.getId());
				mv.addObject("slows", list);
			}
			mv.setViewName("slow_lookfor");
			return mv;
		}else{
			map.put("stuName",stuName);map.put("lesName",lesName );map.put("teaName",teaName );map.put("masName",masName );
			List<Apply> applys=applyservice.getApplyByMap(map);
			System.out.println(applys);
			ModelAndView mv = new ModelAndView();
			mv.addObject("applys", applys);
			mv.addObject("user", user);
			if(status==2){
				List<Apply> list= applyservice.getApplyByTeacherId(user.getId());
				mv.addObject("slows", list);
			}
			if(status==3){
				List<Apply> list= applyservice.getApplyByMasterId(user.getId());
				mv.addObject("slows", list);
			}
			mv.setViewName("slow_lookfor");
			return mv;
		}
		
	}
	
	@RequestMapping(value="good")
	public ModelAndView good(int id,int appId,HttpServletRequest request,HttpServletResponse response){
		User user=userservice.getUserById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		if(user.getStatus()==2){
			applyservice.setStateOne(appId, 1);			
			List<Apply> list= applyservice.getApplyByTeacherId(user.getId());
			mv.addObject("slows", list);
			mv.setViewName("slow_lookfor");
			return mv;
		}
		if(user.getStatus()==3){
			applyservice.setStateTwo(appId, 1);		
			List<Apply> list= applyservice.getApplyByMasterId(user.getId());
			mv.addObject("slows", list);
			mv.setViewName("slow_lookfor");
			return mv;
		}
		return null;
	}
	
	@RequestMapping(value="bad")
	public ModelAndView bad(int id,int appId,HttpServletRequest request,HttpServletResponse response){
		User user=userservice.getUserById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		if(user.getStatus()==2){
			applyservice.setStateOne(appId, -1);			
			List<Apply> list= applyservice.getApplyByTeacherId(user.getId());
			mv.addObject("slows", list);
			mv.setViewName("slow_lookfor");
			return mv;
		}
		if(user.getStatus()==3){
			applyservice.setStateTwo(appId, -1);		
			List<Apply> list= applyservice.getApplyByMasterId(user.getId());
			mv.addObject("slows", list);
			mv.setViewName("slow_lookfor");
			return mv;
		}
		return null;
	}
}