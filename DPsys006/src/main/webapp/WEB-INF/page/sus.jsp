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
		用户名 ：${user.username }
		<dt>可查询次数</dt>
		<dt>可查询时间</dt>
	</dl>

	<dl>
		
		
		<c:forEach items="${user.permissionDatas }" var="permissionData">
			<dt>可查询表：&nbsp;&nbsp;   ${permissionData.dataName }表</dt>
			<dd>可查询字段：&nbsp;&nbsp;  ${permissionData.colName }字段</dd>
			<br />
			
		</c:forEach>
		
		
		请输入你要查询的数据
			<form action="search" method="post">
			表名:<input type="text" name="tableName" /><br /> 
			字段:<input	type="text" name="colName" /><br /> 
			开始:<input	type="text" name="start" /><br /> 
			结束:<input	type="text" name="end" /><br /> 
			<input type="submit" value="查询" /><br />
			</form>
	</dl>

</body>
</html>