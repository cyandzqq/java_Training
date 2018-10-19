<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
  <meta charset="UTF-8"/>
  <title>注册</title>
  <style type=text/css>
    .fh{
         color:red;
         }
    .student{
         border: 1px solid gray;
         background: white;
		 }
    #register{
         color:black;
	     width: 100px;
	     height: 30px;
	     margin-left: 47%;
	     margin-bottom: 0px border: 1px solid gray;
	     font-weight: bold;
         }
    #threebutton{	 
	     width: 200px;
	     height: 10px;
	     margin-left: 45%;	  
         } 
  </style>
  </head>
  <body style="background: url('images/register.jpg') no-repeat center 0px ; background-size: cover;"> 
  
  <!-- 学生注册模块 -->
     <div id="form" style=" text-align: center; width:40%; height: 35%; margin-left: 30%; margin-top: 13%;" >
        <form name="myform"  action="${pageContext.request.contextPath}/tryregister">
	       <div class="input">
		      <br><br>
	          <span class="fh" style="opacity: 1">*</span><span>用户名：</span>&nbsp;&nbsp;&nbsp;&nbsp;
	          <input type="text" class="student" name="username" >
	       </div>
	       <br>
	       <div class="input">
	          <span class="fh">*</span><span>邮箱地址：</span>
	          <input type="text" class="student" name="address" >
	       </div>
	       <br>
	       <div class="input">
	          <span class="fh">*</span><span>密码：</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	          <input type="password" class="student" name="password" >
		   </div>
		   <br>
	          <input type="radio" name ="role" onclick="btn()" value="student" checked="checked">学生
	          <input type="radio" name="role" onclick="btn1()" value="teacher">教师
	          <input type="radio" name="role" onclick="btn2()" value="master">教导主任
		      <br><br>
	       <div><input type="submit" value="注册" id="register" ></div>
        </form>
     </div>  
     
  <!-- 教师注册模块 -->
     <div id="form2" style=" text-align: center; width:40%; height: 35%; margin-left: 30%; margin-top: 13%; display: none;" >
        <form name="myform" action="${pageContext.request.contextPath}/tryregister" >
	       <div class="input">
		      <br><br>
	          <span class="fh" style="opacity: 1">*</span><span>用户名：</span>&nbsp;&nbsp;&nbsp;&nbsp;
	          <input type="text" class="student" name="username" >
	       </div>
	       <br>
	       <div class="input">
	          <span class="fh">*</span><span>邮箱地址：</span>
	          <input type="text" class="student" name="address" >
	       </div>
	       <br>
	       <div class="input">
	          <span class="fh">*</span><span>密码：</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	          <input type="password" class="student" name="password" ></div>
	          <br>
	       <div class="input">
	          <span class="fh">*</span><span>课程id：</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	          <input type="password" class="student" name="subject" >
	       </div>
	       <br>
	       <input type="radio" name ="role" onclick="btn()" value="student" >学生
	       <input type="radio" name="role" onclick="btn1()" value="teacher" checked="checked">教师
	       <input type="radio" name="role" onclick="btn2()" value="master">教导主任
	       <br><br>
	       <div style="margin-bottom: 10px"><input type="submit" value="注册" id="register" ></div>
        </form>
     </div>
   
  <!-- 主任注册模块 -->
     <div id="form3" style=" text-align: center; width:40%; height: 35%; margin-left: 30%; margin-top: 13%; display: none;">
        <form name="myform"  action="${pageContext.request.contextPath}/tryregister">
	       <div class="input">
		      <br><br>
	          <span class="fh" style="opacity: 1">*</span><span>用户名：</span>&nbsp;&nbsp;&nbsp;&nbsp;
	          <input type="text" class="student" name="username" >
	       </div>
	       <br>
           <div class="input">
	          <span class="fh">*</span><span>邮箱地址：</span>
	          <input type="text" class="student" name="address" >
	       </div>
	       <br>
	       <div class="input">
	          <span class="fh">*</span><span>密码：</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	          <input type="password" class="student" name="password" >
	          <br><br>
	          <input type="radio" name ="role" onclick="btn()" value="student" >学生
	          <input type="radio" name="role" onclick="btn1()" value="teacher">教师
	          <input type="radio" name="role" onclick="btn2()" value="master" checked="checked">教导主任
	       </div>
           <br>
	       <div ><input type="submit" value="注册" id="register" ></div>
        </form>
     </div>

   <script> 
     function btn(){   
     document.getElementById("form").style.display="block";
     document.getElementById("form2").style.display="none";
     document.getElementById("form3").style.display="none";  
     }
     function btn1(){   	
     document.getElementById("form").style.display="none";
     document.getElementById("form2").style.display="block";
     document.getElementById("form3").style.display="none";
     }
     function btn2(){   	
     document.getElementById("form").style.display="none";
     document.getElementById("form2").style.display="none";
     document.getElementById("form3").style.display="block";
     }  
   </script>
 </body>  
</html>
