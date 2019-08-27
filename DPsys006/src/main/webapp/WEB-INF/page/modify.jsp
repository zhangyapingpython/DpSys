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
	width: 498px;
	height: 800px;
	/*left的高度也是300px，但是却超出了父级元素的高度，为什么？*/
	border: 1px;
}

#right {
	width: 498px;
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

</style>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
	});
	function show() {
		var toMod=$("#roleID").val();
		//alert("哈哈哈"+toMod)
		window.location.href="modifyPermission?roleID="+toMod
	}

</script>
</head>
<body>
	<div id="div1">
		<div id="right2">
			请输入你要改成的角色ID
			<input type="text" name="roleID" id="roleID"/>
			<button id="modify" onclick="show();">修改</button>
		</div>
		<div id="left">
			要修改的账户名为&nbsp;&nbsp;<font color="#FF0000">${modifyUser.userAccount}</font>
			<table border="1">
				<tr>

					<th>角色名</th>
					<th>角色ID</th>
					<th>权限</th>
				</tr>
				<tr>
					<td>${modifyUser.role.name }</td>
					<td>${modifyUser.role.roleID }</td>
					<td><c:forEach items="${modifyUser.role.permission }"
							var="permission">
							<dt>可查询表：&nbsp;&nbsp; ${permission.dataName }表</dt>
							<dd>可查询字段：&nbsp;&nbsp; ${permission.dataCol }字段</dd>
							<dd>可查询时间：&nbsp;&nbsp; ${permission.queryTime }分钟</dd>
							<dd>可查询次数：&nbsp;&nbsp; ${permission.queryNum }次</dd>
						</c:forEach></td>
				</tr>
			</table>
		</div>

		<div id="right">
			可修改为以下角色
			<table border="1">
				<tr>
					<th>角色名</th>
					<th>角色ID</th>
					<th>权限</th>


				</tr>
				<c:forEach items="${allRoleAndPermissions }" var="role">
					<tr>
						<td>${role.name }</td>
						<td>${role.roleID }</td>
						<td><c:forEach items="${role.permission }" var="permission">
								<dt>可查询表：&nbsp;&nbsp; ${permission.dataName }表</dt>
								<dd>可查询字段：&nbsp;&nbsp; ${permission.dataCol }字段</dd>
								<dd>可查询时间：&nbsp;&nbsp; ${permission.queryTime }分钟</dd>
								<dd>可查询次数：&nbsp;&nbsp; ${permission.queryNum }次</dd>
							</c:forEach></td>
						<td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
	</div>
</body>

</html>
