<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基本的 ssm 框架</title>
<style type="text/css">
	a{
		font-size: 20px;
		display: block;
		margin-top: 30px;
	}
</style>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/addUser.do">
	用户名:<input type="text" name="userName"><br/>
	年龄:<input type="text" name="age"><br/>
	<input type="submit" value="OK">
</form>
<hr/>
<%-- <a href="${pageContext.request.contextPath }/user/addUser.do">添加用户</a> --%>
<a href="${pageContext.request.contextPath }/user/list.do">查找所有用户</a>
<a href="${pageContext.request.contextPath }/user/getUserA.json?id=1">获取某个用户JSON格式1</a>
<a href="${pageContext.request.contextPath }/user/getUserB.json?id=2">获取某个用户JSON格式2</a>
</body>
</html>













