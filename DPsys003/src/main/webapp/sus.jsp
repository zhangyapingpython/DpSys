<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<dl>
		用户名 ：${user.userName }

	</dl>

	<dl>
		
		
		<c:forEach items="${user.powerExes }" var="powerExe">
			<dt>可查询时间：&nbsp;&nbsp;   ${powerExe.queryTime }分钟</dt>
			<dd>可查询次数：&nbsp;&nbsp;  ${powerExe.queryNum }次</dd>		
			<br />	
		</c:forEach>
		
		
		<c:forEach items="${user.powerDatas }" var="powerData">
			<dt>可查询表：&nbsp;&nbsp;   ${powerData.dataName }表</dt>
			<dd>可查询字段：&nbsp;&nbsp;  ${powerData.colName }字段</dd>		
			<br />	
		</c:forEach>
		
		
		请输入你要查询的数据
			<form action="search" method="post">
			表名:<input type="text" name="dataName" /><br /> 
			字段:<input	type="text" name="colName" /><br /> 
			开始:<input	type="text" name="start" /><br /> 
			结束:<input	type="text" name="end" /><br /> 
			<input type="submit" value="查询" /><br />
			</form>
	</dl>

</body>
</html>