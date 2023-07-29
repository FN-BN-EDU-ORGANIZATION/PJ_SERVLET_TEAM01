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

<c:if test="${empty updatedDto}">
<div class="info_block">
ID : ${userDto.id } <br />
NAME : ${userDto.name} <br />
PW : ${userDto.pw}<br />
ADDR : ${userDto.addr}<br />
PHONE : ${userDto.phone} <br />
<%-- <button onclick = "location.href='${pageContext.request.contextPath}/member/update.do'">정보수정</button> --%>
<button onclick= "location.href='${pageContext.request.contextPath}/main.do'">이전</button>
<button onclick = "location.href='${pageContext.request.contextPath}/member/update.do'">정보수정</button>
</div>
</c:if>
<c:if test="${not empty updatedDto}">
<div class="info_block">
ID : ${updatedDto.id } <br />
NAME : ${updatedDto.name} <br />
PW : ${updatedDto.pw}<br />
ADDR : ${updatedDto.addr}<br />
PHONE : ${updatedDto.phone} <br />
<button onclick= "location.href='${pageContext.request.contextPath}/main.do'">이전</button>
<button onclick = "location.href='${pageContext.request.contextPath}/member/update.do'">정보수정</button>
</div>
</c:if>

</body>
</html>