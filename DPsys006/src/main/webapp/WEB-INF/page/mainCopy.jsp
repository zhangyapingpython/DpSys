<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>


</head>
<body>
欢迎 用户名为 ：${user.username } 访问本系统，你的角色为${user.role.name}

你的权限包括
<c:forEach items="${user.role.permission }" var="permission">
			<dt>可查询表：&nbsp;&nbsp;   ${permission.dataName }表</dt>
			<dd>可查询字段：&nbsp;&nbsp;  ${permission.dataCol }字段</dd>
			<dd>剩余查询时间：&nbsp;&nbsp;  ${permission.queryTime }分钟</dd>
			<dd>剩余可查询次数：&nbsp;&nbsp;  ${permission.queryNum }次</dd>
			<br />
			
		</c:forEach>
		
		
		
		
请输入你要查询的数据
			<form action="search" method="post">
			表名:<input  type="text" name="dataName" /><br /> 
			字段:<input	type="text" name="dataCol" /><br /> 
			开始:<input	type="text" name="start" /><br /> 
			结束:<input	type="text" name="end" /><br /> 
			<input type="submit" value="查询" /><br />
			</form>

 
</body>

</html>