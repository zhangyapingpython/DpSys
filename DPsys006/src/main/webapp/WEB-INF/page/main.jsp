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
	width: 800px;
	height: 300px;
	border: 2px;
	margin: 0px auto;
	/*设置外边距上下0px，左右auto，即可实现左右居中的效果*/
}

#left {
	width: 398px;
	height: 300px;
	/*left的高度也是300px，但是却超出了父级元素的高度，为什么？*/
	border: 1px;
}

#right {
	width: 398px;
	height: 300px;
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
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	String.prototype.trim = function() {
		/*去除留白*/
		return this.replace(/(^\s*)|(\s*$)/g, "");
	}
</script>
<script type="text/javascript">
	$(document).ready(function() {

	});
	function checkDataName() {
		var dataName = $("#dataName").val();
		if (dataName == "") {
			$("#messageDataName").html("数据表名字不能为空！");
			return false;
		}else{
			$("#messageDataName").html("");
			return true;
		}

	}

	function checkDataCol() {
		var dataCol = $("#dataCol").val();
		if (dataCol == "") {
			$("#messageDataCol").html("字段不能为空！");
			return false;
		}else{
			$("#messageDataCol").html("");
			return true;
		}
	}

	function checkStart() {
		var start = $("#start").val();
		if (start == "") {
			$("#messageStart").html("不能为空！");
			return false;
		}else{
			$("#messageStart").html("");
			return true;
		}
	}

	function checkEnd() {
		var end = $("#end").val();
		if (end == "") {
			$("#messageEnd").html("不能为空！");
			return false;
		}else{
			$("#messageEnd").html("");
			return true;
		}
	}

	function method() {
		var dataName = $("#dataName").val().trim();
		var dataCol = $("#dataCol").val().trim();
		var start = $("#start").val().trim();
		var end = $("#end").val().trim();
		
		if (dataName == "" || dataName == null) {
			alert("数据表不能为空！");
			return false;
		}
		if (dataCol == "" || dataCol == null) {
			alert("字段不能为空！");
			return false;
		}
		if (start == "" || start == null) {
			alert("字段开始不能为空！");
			return false;
		}
		if (end == "" || end == null) {
			alert("字段结束不能为空！");
			return false;
		}

		$.ajax({
			type : "GET",
			url : "ajax",
			// data:{"id":val},     // data参数是可选的，有多种写法，也可以直接在url参数拼接参数上去，例如这样：url:"getUser?id="+val,
			data : {
				dataName : dataName,
				dataCol : dataCol,
				start : start,
				end : end
			},
			async : true, // 异步，默认开启，也就是$.ajax后面的代码是不是跟$.ajx里面的代码一起执行
			cache : true, // 表示浏览器是否缓存被请求页面,默认是 true
			dataType : "json", // 返回浏览器的数据类型，指定是json格式，前端这里才可以解析json数据
			success : function(data) {
				if (data.error != null) {
					alert(data.error)
				}else if (data.info != null) {
					alert(data.info)
				}else{
					var result = "";
					result += "<caption>";
					result += "<h2>";
					result += "查询结果";
					result += "</h2>";
					result += "</caption>";
					result += "<tr>";
					result += "<td>";
					result += "计数值"
					result += "</td>";
					result += "<td>";
					result += "平均值"
					result += "</td>";
					result += "</tr>";
					result += "<tr>";
					result += "<td>";
					result += data.searchCount;
					result += "</td>";
					result += "<td>";
					result += data.searchAvg;
					result += "</td>";
					result += "</tr>";
					//相当innerHTML先清空后添加
					$("#mytable").html(result);

					var result2 = "";
					result2 += "表";
					result2 += data.dataName;
					result2 += "剩余查询次数";
					result2 += data.remainQueryNum;
					result2 += "  ";
					result2 += "剩余查询时间";
					result2 += data.remainMin;
					result2 += " 分 ";
					result2 += data.remainSecond;
					result2 += " 秒 ";

					$("#mytable2").html(result2);
				}
				//alert("成功请求"+data.searchCount+""+data.searchAvg);
				
			},
			error : function() {
				//console.log("发生错误")
				alert("发生错误，请确认你输入的参数是否有误");
			},
			complete : function() {
				//console.log("ajax请求完事，最终操作在这里完成")
			}
		});
		// alert("测试异步")
	}
</script>

</head>
<body>
	<div id="div1">
		<div id="left">
			欢迎 <font color="#FF0000">${user.username }</font> 访问本系统，你的角色为 <font
				color="#FF0000">${user.role.name} </font>你的权限包括

			<table border="1">
				<c:forEach items="${user.role.permission }" var="permission">
					<dt>可查询表：&nbsp;&nbsp; ${permission.dataName }表</dt>
					<dd>可查询字段：&nbsp;&nbsp; ${permission.dataCol }字段</dd>
					<dd>可查询时间：&nbsp;&nbsp; ${permission.queryTime }分钟</dd>
					<dd>可查询次数：&nbsp;&nbsp; ${permission.queryNum }次</dd>
				</c:forEach>
			</table>
		</div>
		<div id="right">
			<table id="mytable2"></table>
		</div>
	</div>


	<div id="div2">
		<div id="left2">
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
