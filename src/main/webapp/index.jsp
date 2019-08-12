<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="api/login" method="post">
		账号:<input type="text" placeholder="username" name="username"><br>
		密码:<input type="text" placeholder="password" name="password"><br>
		<input type="submit" value="登录">
	</form>
	
	<form action="api/register" method="get">
		账号:<input type="text" placeholder="username" name="username"><br>
		密码:<input type="text" placeholder="password" name="password"><br>
		<input type="submit" value="注册">
	</form>
	

</body>
</html>