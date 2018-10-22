<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="学生选课系统" />
<meta name="description" content="欢迎来到学生选课系统。" /> 
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/demo.css" />
<link rel="stylesheet" href="css/osSlider.css" />
<title>学生选课系统-首页</title>
<style>
/* html.body{
  width:100%;
  height:100%;
} */
body{
  background:#fff url("images/login.jpg") no-repeat left top;
  background-size: 100%;
}
</style>
</head>
<body>
    <div class="htmleaf-container" >
		<div class="slider">
	        <ul class="slider-main">
	            <a href="${pageContext.request.contextPath}/login" target="_blank">
		            <li>
		                <img src="images/g.jpg" alt="">
		            </li>
	            </a>
	            <a href="${pageContext.request.contextPath}/login" target="_blank">
		            <li>
		                <img src="images/b.jpg" alt="">
		            </li>
	            </a>
	            <a href="${pageContext.request.contextPath}/login" target="_blank">
		            <li>
		                <img src="images/d.jpg" alt="">
		            </li>
	            </a>
	            <a href="${pageContext.request.contextPath}/login" target="_blank">
		            <li>
		                <img src="images/e.jpg" alt="">
		            </li>
	            </a>
	        </ul>
	    </div>

	</div>
	
	<script src="js/jquery-2.1.1.min.js"></script>
	<script src="js/osSlider.js"></script>
	<script type="text/javascript">
	    var slider = new osSlider({ //开始创建效果
	        pNode:'.slider', //容器的选择器 必填
	        cNode:'.slider-main li', //轮播体的选择器 必填
	        speed:3000, //速度 默认3000 可不填写
	        autoPlay:true //是否自动播放 默认true 可不填写
	    });
	</script>
</body>
</html>