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
   <form action="${pageContext.request.contextPath}/updateStudent?id=${stuid}">
        <table border="1" align="center">
             <th>序号<input type="text" name="id" value="${stuid}"></th>
        	<br>
        	<th>姓名<input type="text" name="name" id="name"></th>
        	<br>
        	<th>年龄<input type="text" name="age" id="age"></th>
        	<br>
        	<th>班级<input type="text" name="cla" id="cla"></th>
        	<br>
        	<th><input type="submit" value="提交"></th>
         </table>
         </form>
  </body>
</html>
