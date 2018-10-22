<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
  <meta charset="UTF-8"/>
  <title>学生选课系统</title>
  <style type=text/css>
    .fh{color:red;}
    .student{
         border: 1px solid gray;
         background: white;
		 }
    #login{
         color:black;
	     width: 100px;
	     height: 30px;	  
	     border: 1px solid gray;
	     font-weight: bold;
         }
    #register{
         color:black;
	     width: 100px;
	     height: 30px;	  
	     border: 1px solid gray;
	     font-weight: bold;
         }
  </style>
  </head>
  <body style="background: url('images/login.jpg') no-repeat center 0px ; background-size: cover;">
     <div id="form" style=" text-align: center; width:40%; height: 30%; margin-left: 30%; margin-top: 13%;"  >
        <form name="myform"  action="${pageContext.request.contextPath}/trylogin">	
	        <br><br>
	        <div class="input">
	             <span class="fh">*</span><span>邮箱地址：</span>
	             <input type="text" class="student" name="address" placeholder="请输入邮箱">
	        </div>
	        <br>
	        <div class="input">
	             <span class="fh">*</span><span>密码：</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	             <input type="password" class="student" name="password" placeholder="请输入密码">
	        </div>
            <br><br>
	        <div>
	             <input type="submit" value="登录" id="login" >
                 <a href="${pageContext.request.contextPath}/register">注册</a>
	        </div>
        </form>
     </div>
  </body>  
</html>
