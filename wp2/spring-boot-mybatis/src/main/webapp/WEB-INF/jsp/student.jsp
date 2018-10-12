<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
  </head>
  <body>
   <%-- <strong>HI ${student.name} ,</strong> <br/>
   <strong>HI ${student.age} ,</strong>  --%>
   <form action="${pageContext.request.contextPath}/selectStudentbymap">
    <table border="1" align="center">
     <th>姓名<input type="text" name="name" id="name"></th>
     <th>年龄<input type="text" name="age" id="age"></th>
     <th>班级<input type="text" name="cla" id="cla"></th>
     <th><input type="submit" value="搜索" ></th>
    </table>
   </form>
        <table border="1" align="center">
            <th>序号</th>
        	<th>姓名</th>
        	<th>年龄</th>
        	<th>班级</th>
        	<th>地址</th>
        	<th>操作</th>
          <c:forEach var="st" items="${students}" >
         	<tr>
         		<td>${st.stuId }</td>
         		<td>${st.stuName }</td>
         		<td>${st.stuAge }</td>
         		<td>${st.claId}</td>
         		<td>${st.address.addName }</td>
         		<td><a href="${pageContext.request.contextPath}/deleteStudent?id=${st.stuId}">删除</a><a href="${pageContext.request.contextPath}/updateStudent0?id=${st.stuId}">编辑</a></td>
         	</tr>
         	
         </c:forEach>
         </table>
  </body>
</html>
