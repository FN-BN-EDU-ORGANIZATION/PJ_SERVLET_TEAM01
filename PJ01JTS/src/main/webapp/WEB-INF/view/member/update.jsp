<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원정보수정 PAGE</h1>
ID : ${id } <br />
NAME : ${userDto.name} <br />
PW : <input name="pw" value="${userDto.pw}" /><br />
ADDR : <input name="addr" value="${userDto.addr}"  /><br />
PHONE : <input name="phone" value="${userDto.phone }"/>
</body>
</html>