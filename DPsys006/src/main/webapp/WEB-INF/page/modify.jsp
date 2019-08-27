<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<title>主页面</title>
</head>
<body>
	<div id="div1">
		<div id="left">
			欢迎 <font color="#FF0000">${user.username }</font> 访问本系统，你的角色为 <font
				color="#FF0000">${user.role.name} </font>

			<table border="1">
				<tr>
					<th>账号</th>
					<th>角色</th>
					<th>权限</th>
					<th>操作</th>
				</tr>

				<c:forEach items="${usersInfo }" var="user">
					<tr>
						<td>${user.userAccount }</td>
						<td>${user.role.name }</td>
						<td><c:forEach items="${user.role.permission }"
								var="permission">
								<dt>可查询表：&nbsp;&nbsp; ${permission.dataName }表</dt>
								<dd>可查询字段：&nbsp;&nbsp; ${permission.dataCol }字段</dd>
								<dd>可查询时间：&nbsp;&nbsp; ${permission.queryTime }分钟</dd>
								<dd>可查询次数：&nbsp;&nbsp; ${permission.queryNum }次</dd>
							</c:forEach></td>
						<td><a href="modify">修改角色及权限</a></td>
					</tr>
				</c:forEach>
			</table>
			<a
				href="page?pageNumber=${PageInfo.pageNumber-1 }&pageSize=${PageInfo.pageSize}"
				<c:if test="${PageInfo.pageNumber<=1 }">  onclick="javascript:return false;" </c:if>>上一页</a>
			<a
				href="page?pageNumber=${PageInfo.pageNumber+1 }&pageSize=${PageInfo.pageSize}"
				<c:if test="${PageInfo.pageNumber>=PageInfo.total }">  onclick="javascript:return false;" </c:if>>下一页</a>
		</div>


		<div id="div2">
			<h2>请输入查询数据</h2>
			<table>
				<tr>
					<td>数据表名：</td>
					<td><input type="text" name="dataName" id="dataName"
						onblur="checkDataName()"></td>
					<td><span id="messageDataName"></span></td>
				</tr>
				<tr>
					<td>字段名：</td>
					<td><input type="text" name="dataCol" id="dataCol"
						onblur="checkDataCol()"></td>
					<td><span id="messageDataCol"></span></td>
				</tr>
				<tr>
					<td>此字段的开始：</td>
					<td><input type="text" name="start" id="start"
						onblur="checkStart()"></td>
					<td><span id="messageStart"></span></td>
				</tr>
				<tr>
					<td>此字段的结束：</td>
					<td><input type="text" name="end" id="end" onblur="checkEnd()"></td>
					<td><span id="messageEnd"></span></td>
				</tr>
			</table>
			<button onclick="method();">查询</button>
		</div>

		<div id="right2">
			<table id="mytable" border="2"></table>
		</div>
	</div>
</body>

</html>
