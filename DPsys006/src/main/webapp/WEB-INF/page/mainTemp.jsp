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
	function method() {
		var val = $("#userId").val();
		$.ajax({
			type : "GET",
			url : "ajax",
			// data:{"id":val},     // data参数是可选的，有多种写法，也可以直接在url参数拼接参数上去，例如这样：url:"getUser?id="+val,
			data : "id=" + val,
			async : true, // 异步，默认开启，也就是$.ajax后面的代码是不是跟$.ajx里面的代码一起执行
			cache : true, // 表示浏览器是否缓存被请求页面,默认是 true
			dataType : "json", // 返回浏览器的数据类型，指定是json格式，前端这里才可以解析json数据
			success : function(data) {
				alert("成功请求"+data);
				$("#name").text(data.name);
				$("#age").text(data.age);
			},
			error : function() {
				console.log("发生错误")
				alert("发生错误");
			},
			complete : function() {
				console.log("ajax请求完事，最终操作在这里完成")
			}
		});
		// alert("测试异步")
	}
</script>
</head>
<body>

	<input type="text" id="userId" />
	<button onclick="method();">获取</button>
	<div>
		名字：<span id="name"></span>
	</div>
	<div>
		年龄<span id="age"></span>
	</div>
</body>

</html>
