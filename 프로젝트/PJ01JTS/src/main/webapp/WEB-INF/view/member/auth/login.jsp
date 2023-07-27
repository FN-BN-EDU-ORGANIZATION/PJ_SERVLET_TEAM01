<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>LOGIN</h1>
<form action="post">
	ID : <input name="id" /><br>
	PW : <input name="pw" type="password" /><br>
	<input type="submit" value="로그인" />
</form>

<hr/>
<div class="msg">
	${msg}
</div>


</body>
</html>