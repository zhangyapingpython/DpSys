<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<title>主页面</title>
<style type="text/css">
#div1 {
	width: 1000px;
	height: 800px;
	border: 2px;
	margin: 0px auto;
	/*设置外边距上下0px，左右auto，即可实现左右居中的效果*/
}

#left {
	width: 598px;
	height: 800px;
	/*left的高度也是300px，但是却超出了父级元素的高度，为什么？*/
	border: 1px;
}

#right {
	width: 398px;
	height: 800px;
	border: 1px;
}

#left, #right {
	float: left;
}

#div2 {
	width: 800px;
	height: 300px;
	border: 2px;
	margin: 0px auto;
	/*设置外边距上下0px，左右auto，即可实现左右居中的效果*/
}

#left2 {
	width: 398px;
	height: 300px;
	/*left的高度也是300px，但是却超出了父级元素的高度，为什么？*/
	border: 1px;
}

#right2 {
	width: 398px;
	height: 300px;
	border: 1px;
}

#left2, #right2 {
	float: left;
}

</style>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
	});
	function show(e) {
		var toMod=$(e).attr("custom")
		alert("哈哈哈"+$(e).attr("custom"))
		window.location.href="managePermisson?userID="+toMod
	}

</script>	
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
						<td><button id="${user.userAccount}" custom="${user.userID}" onclick="show(this);">修改</button></td>
					</tr>
				</c:forEach>
			</table>
			
		</div>


		<div id="right2" >
			<table id="mytable" border="2"></table>
			 
			 <input type="button" id="hidden" onclick="hidden()" value="确认修改" />
		</div>
	</div>
	
	
</body>

</html>
