<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
 	<title>登录失败</title>
	<meta charset="UTF-8"/>
  </head>
  <body style=" background: url('images/login.jpg') no-repeat center 0px ; background-size: cover; ">
	 <div>
	    <div style="text-align: center; height: 30%;width: 30%; background-color: #99CCFF; margin-left: 40%; margin-top: 20%">		
           <h1>登录失败</h1>
           <br><br>
           <a href="${pageContext.request.contextPath}/login"><button>确定</button></a>
	    </div>
     </div>
  </body>  
</html>
