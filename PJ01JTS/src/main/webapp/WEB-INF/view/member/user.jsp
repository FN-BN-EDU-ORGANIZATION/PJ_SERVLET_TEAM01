<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>USER PAGE</h1>
ID : ${id} <br/>
NAME : ${name} <br />
ADDR : ${addr} <br />
PHONE : ${phone} <br />
<button onclick = "location.href='${pageContext.request.contextPath}/member/update.do'">정보수정</button>

</body>
</html>