<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>USER PAGE</h1>
<div class="info_block">
id : ${id }<br>
role : ${role }<br>
ID : ${userDto.id } <br />
NAME : ${userDto.name} <br />
PW : ${userDto.pw}<br />
ADDR : ${userDto.addr}<br />
PHONE : ${userDto.phone}
<button onclick = "location.href='${pageContext.request.contextPath}/member/add.do'">정보수정</button>


</div>
</body>
</html>