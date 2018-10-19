<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>学生选课系统</title>
  <script src="http://img.jb51.net/jslib/jquery/jquery.js" type="text/javascript"></script> 
  <script src="jquery-1.3.2.js" type="text/javascript"></script>
  <style type=text/css >
    .fh{color:red;}
    .student{
             border: 1px solid gray;
             background: white;
             }
    #studentrequire{
             height:100%;width:100%; line-height:24px;border-top:none;  padding:1px; padding:10px
             }
    table{
          border-collapse:collapse;
          border:1px solid #0F0;
          }
    tr{
       border:1px solid lightgray;
       }
    td{
       border:0px;
       }
  </style>
  <script type="text/javascript">
        $(document).ready(function(){
           $("#province").change(function(){
               $("#province option").each(function(i,o){
                    if($(this).attr("selected")){
                       $(".city").hide();
                       $(".city").eq(i).show();
                    }
                });
            });
              $("#province").change();
        });
 </script>
 </head>
 <body style=" background: url('images/web.jpg') no-repeat center 0px ; background-size: cover; ">
  
  <!-- 眉头选项卡 -->
		 <div>
             <button onclick ="change2()"  style="height: 30px; width: 50px ;border-width:0; ">查阅</button>
             <button onclick="change()" style=" height: 30px; width: 50px;border-width:0; " >申请</button>
         </div>
         
  <!-- 申请表查询模块 -->
         <div id="require" style=" background: url('images/web.jpg') no-repeat center 0px ; background-size: over; width:100%; " >
             <form action="${pageContext.request.contextPath}/studentlookfor">
                 <p>学生名：<input type="text" name="stuName"/>   学号：<input type="text" name="stuNum"/>
                                          课程名：<input type="text" name="lesName"/>  教师名：<input type="text" name="teaName"/>
	 		            教导主任：<input type="text" name="masName"/></p>
			     <input type="hidden" name="userId" value="${user.id}"/>
			     <input type="submit" style="margin-left:85%;margin-top: 30px;width: 80px;height: 30px;background: white" id="select" value="查询"/>
	         </form>
	     <br/><br/>
	     <table style="margin-left: 10px;text-align:center;border: 1px solid lightgrey;background: white;width: 95%;height: 100px;" id="studentrequire">
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
                            <td width="75px" height="30px">${app.submit}</td>
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

  <!-- 申请表填写模块 -->
         <div id="apply" style=" background-color: #99CCFF; text-align: center; width:50%; height:60%; margin-left: 30%; margin-top: 13%; display: none;" >
         <br/>
                                  申请单号：<input type="text" value="${count+1}" disabled="disabled"/>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 学生姓名：<input type="text" value="${user.name}" disabled="disabled"/>
	         <br/><br/>
	         <form action="${pageContext.request.contextPath}/apply">
	              <input type="hidden" value="${user.id}" name="id"/>
	                                   课程：<select id="province" name="lesson">
                          <c:forEach var="les" items="${lessons}">
                             <option value="${les.id}">${les.name}</option>
                          </c:forEach>        
                       </select>
         	               教师：<c:forEach var="les" items="${lessons}">
                          <select class="city" name="${les.name}">
                              <c:forEach var="tea" items="${les.tealist}">
                                  <option value="a">--选择教师--</option>
                                  <option value="${tea.id}">${tea.name}</option>
                              </c:forEach>
                          </select>  
                       </c:forEach>
         
         	               教导主任：<select name="master">
                            <c:forEach var="mas" items="${masters}">
	                            <option value="${mas.id}">${mas.name}</option>
	                        </c:forEach>
	                     </select>	
	              <br/><br/>
	              <div class="input">
	                  <span class="fh">*</span><span>学号：</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		              <input type="text" class="student" name="student_id"/>
	              </div>
	              <br/>
                  <div class="input">
	                  <span class="fh">*</span><span>班级：</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                  <input type="password" class="student" name="class"/>
	              </div>
                  <br/>
                  <div class="input">
	                  <span class="fh">*</span><span>邮箱：</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                  <input type="password" class="student" name="email" />
	              </div>
                  <br/>
                  <div class="input">
	                  <span class="fh">*</span><span>手机号码：</span>
	                  <input type="password" class="student" name="phone" />
                  </div>
                  <input type="submit" value="提交"/>
                  <br/><br/>
	         </form>
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
  <script type="text/javascript">
        $(document).ready(function(){
             $("#province").change(function(){
                $("#province option").each(function(i,o){
                    if($(this).attr("selected"))
                   {
                       $(".city").hide();
                        $(".city").eq(i).show();
                   }
               });
            });
            $("#province").change();
       });
 </script>
 </body>
</html>