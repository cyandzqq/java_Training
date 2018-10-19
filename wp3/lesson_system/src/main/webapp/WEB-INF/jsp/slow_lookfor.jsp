<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
 	<meta charset="UTF-8"/>
<title>学生选课系统</title>
<style type=text/css>


.fh{color:red;}

.student{border: 1px solid gray;
         background: white;
		 }

#studentrequire{
       height:100%;width:100%; line-height:24px;border-top:none;  padding:1px; padding:10px
}

 table{

          border-collapse:collapse;//表格单元格间距样式
          border:1px solid #0F0;
}

tr{border:1px solid lightgray;}
td{
border:0px;}


 </style>
  </head>
  <body style=" background: url('images/web.jpg') no-repeat center 0px ; background-size: cover; ">
		 <div style="">
         <button onclick ="change2()"  style="height: 30px; width: 50px ;border-width:0; ">查阅</button>
          <button onclick="change()" style=" height: 30px; width: 50px;border-width:0; " >审批</button>
        </div>
<div id="require" style=" background: url('images/web.jpg') no-repeat center 0px ; background-size: over; width:100%; " >
    <form action="${pageContext.request.contextPath}/teacherlookfor">
    <p>学生名：<input type="text" name="stuName">   学号：<input type="text" name="stuNum">
	 课程名：<input type="text" name="lesName">  教师名：<input type="text" name="teaName">
	教导主任：<input type="text" name="masName"></p>
	<input type="hidden" name="userId" value="${user.id}">
	<input type="submit" style="margin-left:85%;margin-top: 30px;width: 80px;height: 30px;background: white" id="select" value="查询">
	</form>
	<br><br>
	 <table style="margin-left: 10px;text-align:center;border: 1px solid lightgrey;background: white;width: 95%;height: 100px;" 
	 id="studentrequire">
                        <tr style="border:1px solid lightgrey;">
                            <td width="75px" height="30px">学生姓名</td>
                            <td width="75px" height="30px">学号</td>
                            <td width="75px" height="30px">课程名</td>
                            <td width="75px" height="30px">教师名</td>
                            <td width="75px" height="30px">教导主任</td>
                            <td width="75px" height="30px">学生电话</td>
                            <td width="75px" height="30px">学生邮箱</td>
                            <td width="75px" height="30px">提交时间</td>
                            <td width="75px" height="30px">当前状态</td>
                        </tr>
                        <c:forEach var="app" items="${applys}">
                        <tr>
                                <td width="75px" height="30px">${app.stuName}</td>
                                <td width="75px" height="30px">${app.stuNum}</td>
                                <td width="75px" height="30px">${app.lesName}</td>
                                <td width="75px" height="30px">${app.teaName}</td>
                                <td width="75px" height="30px">${app.masName}</td>
                                <td width="75px" height="30px">${app.phone}</td>
                                <td width="75px" height="30px">${app.email}</td>
                                <td width="75px" height="30px">${app.timesubmit}</td>
                                <td width="75px" height="30px">
                                <c:if test="${(app.stateOne==1)&&(app.stateTwo==1)}">通过</c:if>
                                <c:if test="${(app.stateOne==1)&&(app.stateTwo==-1)}">被拒</c:if>
                                <c:if test="${(app.stateOne==1)&&(app.stateTwo==0)}">审核1</c:if>
                                <c:if test="${app.stateOne==0}">等待</c:if>
                                <c:if test="${app.stateOne==-1}">被拒</c:if>
                                </td>
                            </tr>
                            </c:forEach>
                    </table>
   </div>



   <div id="apply" style=" background-color: #99CCFF; text-align: center; width:50%; height:60%; margin-left: 30%; margin-top: 13%; display: none;" >
    <h1>申请名单</h1>
     
	 <table  border="0" ; style="margin-left: 15px; text-align: center; background-color: white; ">
        <tr>
        <td width="85px" height="30px">学生姓名</td>
        <td width="85px" height="30px">课程</td>
        <td width="85px" height="30px">学号</td>
        <td width="85px" height="30px" >授课老师</td>
        <td width="85px" height="30px">教导主任</td>
        <td width="85px" height="30px">学生邮箱</td>
        <td width="150px" height="30px">操作</td>
    </tr>
    <c:forEach var="slow" items="${slows}" >
    <tr>
        <td width="75px" height="30px">${slow.stuName}</td>
        <td width="75px" height="30px">${slow.lesName}</td>
        <td width="75px" height="30px">${slow.stuNum}</td>
        <td width="75px" height="30px">${slow.teaName}</td>
        <td width="75px" height="30px">${slow.masName}</td>
        <td width="75px" height="30px">${slow.email}</td>
        <td width="150px" height="30px">
        <a href="${pageContext.request.contextPath}/good?id=${user.id}&appId=${slow.id}"><button>同意</button></a>
        <a href="${pageContext.request.contextPath}/bad?id=${user.id}&appId=${slow.id}"><button>拒绝</button></a>
        </td>
    </tr>
   </c:forEach>
    
    </table>
    
   </div>


   <script type="text/javascript">
   	
   	function change(){
   
   document.getElementById("apply").style.display="block";
   document.getElementById("require").style.display="none";
  
   }
   function change2(){
   
   document.getElementById("require").style.display="block";
   document.getElementById("apply").style.display="none";
   }
   </script>
</body>
  
</html>