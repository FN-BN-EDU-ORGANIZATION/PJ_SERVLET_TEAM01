<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>MAIN</h1>
Account : ${id} <br/>
Role : ${role} <br/>
<hr>
<!-- ���� �޴��̵� -->
<c:if test="${not empty role}">
	<a href=<c:url value="/mypage.do" /> >����������</a></br>
</c:if>

<!-- �缭 �޴��� �̵��ϱ� -->
<!-- ȸ�� �޴��� �̵��ϱ� -->


<hr/>

<c:if test="${empty role}">
	<a href=<c:url value="/login.do" /> >LOGIN</a></br>
</c:if>
<c:if test="${not empty role}">
	<a href=<c:url value="/logout.do" /> >LOGOUT</a></br>
</c:if>




<hr/>
<div class=msg>
${msg}
</div>



</body>
</html>