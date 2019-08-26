<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页面</title>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	String.prototype.trim = function() {/*对string对象当中所指定的方法进行重写操作,replace() 方法用于在字符串中用一些字符替换另一些字符，或替换一
	个与正则表达式匹配的子串。*/
		return this.replace(/^\s+/, "").replace(/\s+$/, "");/*\s代表空白字符串，将其替换为空串^为开头$为结尾*/
	}
</script>
<script type="text/javascript">
	$(document).ready(function() {

	});
	function checkUserAccount() {
		var userAccount = $("#userAccount").val();
		if (!/^\w{4,25}$/.test(userAccount)) {
			alert("您的用户名必须是数字或字母且在4到25为之间");
			return;
		}

		$.ajax({
			type : "GET",
			url : "checkRegistUserAccount",
			// data:{"id":val},     // data参数是可选的，有多种写法，也可以直接在url参数拼接参数上去，例如这样：url:"getUser?id="+val,
			data : {
				userAccount : userAccount
			},
			async : false, // 同步，默认开启，也就是$.ajax后面的代码是不是跟$.ajx里面的代码一起执行
			cache : true, // 表示浏览器是否缓存被请求页面,默认是 true
			dataType : "json", // 返回浏览器的数据类型，指定是json格式，前端这里才可以解析json数据
			success : function(data) {//回调函数，data是返回的数据
				$("#errorAccount").html(data.info);
			},
			error : function() {
				//console.log("发生错误")
				alert("发生错误，请确认你输入的参数是否有误");
			},
			complete : function() {

			}
		});
	}
	//表单验证
	function check() {
		var userAccount = $("#userAccount").val();
		var password = $("#password").val();
		alert("密码"+password)
		var password2 = $("#password2").val();
		var username = $("#username").val();
		var telephone = $("#telephone").val();
		var email = $("#email").val();
		//这个不一样
		var errorAccount = $("#errorAccount").html();
		//邮箱验证 test为正则表达式
		var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;

		//alert("error  "+errorAccount);
		if (userAccount == "" || userAccount == null) {
			alert("用户名不能为空！");
			return false;
		}
		if (errorAccount == "该账户已被占用") {
			alert("该账户已被占用,不能注册！");
			return false;
		}
		if (!/^\w{4,25}$/.test(userAccount)) {
			alert("您的用户名必须是数字或字母且在4到25为之间");
			return false;
		}

		if (password == "" || password == null) {
			alert("密码不能为空！");
			return false;
		}

		if (!/^\w{4,25}$/.test(password)) {
			alert("您所输入的密码必须是数字或字母且在4到25为之间");
			return false;
		}

		if (password != password2) {
			alert("您所输入两次密码不匹配");
			return false;
		}

		if (telephone == "" || telephone == null) {
			alert("手机号不能为空！");
			return false;
		}

		if (!(/^1[3456789]\d{9}$/.test(telephone))) {
			alert("手机号码有误，请重填");
			return false;
		}
		
		if (email == "" || email == null) {
			alert("邮箱不能为空！");
			return false;
		}

		if (!(reg.test(email))) {
			alert("邮箱格式有误，请重填");
			return false;
		}
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
					<td><input type="text" name="userAccount" id="userAccount" placeholder="请输入你的账户，长度不能小于4"
						onblur="checkUserAccount()" /></td>
					<td><span id="errorAccount"></span></td>

				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password" id="password" placeholder="请输入你的密码，长度不能小于4"/></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" name="password2" id="password2" placeholder="请确认你的密码，长度不能小于4"/></td>
				</tr>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="username" id="username" placeholder="请输入你的用户名"/></td>
				</tr>
				<tr>
					<td>电话号码：</td>
					<td><input type="text" name="telephone"  id="telephone" placeholder="请输入合法的手机号"/></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><input type="text" name="email"  id="email" placeholder="请输入合法的邮箱"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="注册"
						onclick="return check(this.form)"> <input type="reset"
						value="重置"></td>
				</tr>
			</table>
		</form>
	</center>

</body>
</html>