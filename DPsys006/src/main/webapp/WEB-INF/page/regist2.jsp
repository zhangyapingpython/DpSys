<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

	});
	function checkUserAccount() {
		var userAccount = $("#userAccount").val();
		alert("userAccount  "+userAccount);
		$.ajax({
			type : "GET",
			url : "checkRegistUserAccount",
			// data:{"id":val},     // data参数是可选的，有多种写法，也可以直接在url参数拼接参数上去，例如这样：url:"getUser?id="+val,
			data : {
				userAccount : userAccount
			},
			async : true, // 异步，默认开启，也就是$.ajax后面的代码是不是跟$.ajx里面的代码一起执行
			cache : true, // 表示浏览器是否缓存被请求页面,默认是 true
			dataType : "html", // 返回浏览器的数据类型，指定是json格式，前端这里才可以解析json数据
			success : function(data) {//回调函数，data是返回的数据
				$("#errorAccount").html(data);
			},
			error : function() {
				//console.log("发生错误")
				alert("发生错误，请确认你输入的参数是否有误");
			},
			complete : function() {
			
			}
		});
		// alert("测试异步")
	}
</script>
</head>
<body>
	<center>
		<form action="regist2" method="post">
			<table>
				<caption>注册的页面</caption>
				<tr>
					<td>账号：</td>
					<td><input type="text" name="userAccount" id="userAccount"
						onblur="checkUserAccount()" />
						<div id="errorAccount" style="color: red; display: inline;"></div>
					</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>电话号码：</td>
					<td><input type="text" name="telphone" /></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="注册"> <input
						type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</center>

</body>
</html>