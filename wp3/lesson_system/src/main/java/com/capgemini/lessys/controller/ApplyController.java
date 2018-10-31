package com.capgemini.lessys.controller;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.lessys.bean.Apply;
import com.capgemini.lessys.bean.JavaWebToken;
import com.capgemini.lessys.bean.Lesson;
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
	
	//帮助生成单号
	@RequestMapping(value="count")
	@ResponseBody
	public int count(HttpServletRequest request,HttpServletResponse response){
		String token=request.getParameter("token");
		User user=JavaWebToken.unsign(token,User.class);
		if(user!=null){
			String email=user.getEmail();
			String password=user.getPassword();
			User user1=userservice.ensure(email, password);
			if(user1!=null){return applyservice.getcount();}
			else{return -1;}
		}		
		
		return -1;
	}
	
	//返回所有课程
	@RequestMapping(value="getlessons")
	@ResponseBody
	public List<Lesson> getlessons(HttpServletRequest request,HttpServletResponse response){
		return scheduleservice.getAllLesson();			
	}
	
	//返回所有主任
	@RequestMapping(value="getmasters")
	@ResponseBody
	public List<User> getmastesrs(HttpServletRequest request,HttpServletResponse response){
		return userservice.getMaster();			
		}
	
	//学生提交申请的处理
	@RequestMapping(value="apply")
	@ResponseBody
	public int apply(HttpServletRequest request,HttpServletResponse response){
		int id=Integer.parseInt(request.getParameter("id"));//学生id	
		String lessonid=request.getParameter("lesid");
		String teacherid=request.getParameter("teaid");
		if(lessonid==""||lessonid==null||teacherid==null||teacherid==""){return 0;}
		int lesid=Integer.parseInt(lessonid);//课程id		
		int teaid=Integer.parseInt(teacherid);	
		int masid=Integer.parseInt(request.getParameter("masid"));//主任id
		int stuNum=Integer.parseInt(request.getParameter("student_id"));//学生学号
		String cla=request.getParameter("class");//班级
		String email=request.getParameter("email");//邮件
		String phone=request.getParameter("phone");//手机号码
		Apply myapply=new Apply(id, stuNum, cla, lesid, teaid, masid, phone, email, new Date());
		if(applyservice.getApplyByStuAndLesId(id,lesid)){
		    applyservice.addApply(myapply);
		    System.out.println("添加申请表成功");
			return 1;
		}
		else{
        	    System.out.println("添加申请表失败");       		
        		return 0;
	    }
	}
	
	//学生查询申请的处理
	@RequestMapping(value="studentlookfor")
	@ResponseBody
	public List<Apply> studentlookfor(HttpServletRequest request,HttpServletResponse response){
		String stuName=request.getParameter("stuName");
		String num=request.getParameter("stuNum");
		String lesName=request.getParameter("lesName");
		String teaName=request.getParameter("teaName");
		String masName=request.getParameter("masName");
		Map<String, Object> map=new HashMap<>();
		if(num!=null&&num!=""){
			int i=Integer.parseInt(num);
			map.put("stuName",stuName);map.put("stuNum",i );map.put("lesName",lesName );map.put("teaName",teaName );map.put("masName",masName );
			List<Apply> applys=applyservice.getApplyByMap(map);
			for(int j=0;j<applys.size();j++){
				applys.get(j).setSubmit(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(applys.get(j).getTimesubmit()));
			}
			return applys;
		}else{
			map.put("stuName",stuName);map.put("lesName",lesName );map.put("teaName",teaName );map.put("masName",masName );
			List<Apply> applys=applyservice.getApplyByMap(map);
			for(int j=0;j<applys.size();j++){
				applys.get(j).setSubmit(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(applys.get(j).getTimesubmit()));
			}
			return applys;
		}	
	}
	
	//老师和主任查询申请的处理
	@RequestMapping(value="teacherlookfor")
	@ResponseBody
	public List<Apply> teacherlookfor(HttpServletRequest request,HttpServletResponse response){
		String stuName=request.getParameter("stuName");
		String num=request.getParameter("stuNum");
		String lesName=request.getParameter("lesName");
		String teaName=request.getParameter("teaName");
		String masName=request.getParameter("masName");
		Map<String, Object> map=new HashMap<>();
		if(num!=null&&num!=""){
			int i=Integer.parseInt(num);
			map.put("stuName",stuName);map.put("stuNum",i );map.put("lesName",lesName );map.put("teaName",teaName );map.put("masName",masName );
			List<Apply> applys=applyservice.getApplyByMap(map);
			for(int j=0;j<applys.size();j++){
				applys.get(j).setSubmit(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(applys.get(j).getTimesubmit()));
			}
			return applys;
		}else{
			map.put("stuName",stuName);map.put("lesName",lesName );map.put("teaName",teaName );map.put("masName",masName );
			List<Apply> applys=applyservice.getApplyByMap(map);
			for(int j=0;j<applys.size();j++){
				applys.get(j).setSubmit(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(applys.get(j).getTimesubmit()));
			}
			return applys;
		}	
		
	}
	
	//老师或者主任审批同意的处理
	@RequestMapping(value="good")
	@ResponseBody
	public void good(HttpServletRequest request,HttpServletResponse response){
		int id=Integer.parseInt(request.getParameter("id"));
		int appId=Integer.parseInt(request.getParameter("appId"));
		User user=userservice.getUserById(id);
		if(user.getStatus()==2){
			applyservice.setStateOne(appId, 1);			
		}
		if(user.getStatus()==3){
			applyservice.setStateTwo(appId, 1);		
		}
	    }
	
	//老师或者主任审批拒绝的处理
	@RequestMapping(value="bad")
	@ResponseBody
	public void bad(HttpServletRequest request,HttpServletResponse response){
		int id=Integer.parseInt(request.getParameter("id"));
		int appId=Integer.parseInt(request.getParameter("appId"));
		User user=userservice.getUserById(id);
		if(user.getStatus()==2){
			applyservice.setStateOne(appId, -1);			
		}
		if(user.getStatus()==3){
			applyservice.setStateTwo(appId, -1);		
		}
	}
	
	//老师或者主任显示审批的申请表
	@RequestMapping(value="getApplysById")
	@ResponseBody
	public  List<Apply> getApplysById(HttpServletRequest request,HttpServletResponse response){
		if(request.getParameter("id")!=null){
		int id=Integer.parseInt(request.getParameter("id"));
		User user=userservice.getUserById(id);
		if(user.getStatus()==2){return applyservice.getApplyByTeacherId(id);}
		else if(user.getStatus()==3){return applyservice.getApplyByMasterId(id);}
		else{return null;}
	}
		return null;
	}
}
