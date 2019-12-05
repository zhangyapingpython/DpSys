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
<script type="text/javascript">
	$(document).ready(function() {

	});

	function query() {
		var sqlString = $("#sqlQuery").val();
		alert("sqlString  ！"+sqlString);

		if (sqlString == "" || dataName == null) {
			alert("查询不能为空！");
			return false;
		}

		$.ajax({
			type : "GET",
			url : "sqlQuery",
			data : {
				sqlString : sqlString

			},
			async : true, // 异步，默认开启，也就是$.ajax后面的代码是不是跟$.ajx里面的代码一起执行
			cache : true, // 表示浏览器是否缓存被请求页面,默认是 true
			dataType : "json", // 返回浏览器的数据类型，指定是json格式，前端这里才可以解析json数据
			success : function(data) {
				if (data.statu != 200) {
					alert(data.error)
				} else {
					alert(data.result);
				}

			},
			error : function() {
				alert("发生错误，请确认你输入的参数是否有误");
			},
		
		});
	}
</script>
<body>
	<table>
		<tr>
			<td>请输入查询语句:</td>
			<td><input type="text" name="sqlQuery" id="sqlQuery"
				onblur="checkSqlQuery()"></td>
		</tr>
	</table>
	<button onclick="query();">查询</button>
</body>
</html>
