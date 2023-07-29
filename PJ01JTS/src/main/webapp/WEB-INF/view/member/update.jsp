<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원정보수정 페이지</title>
</head>
<body>
    <h1>회원정보수정 PAGE</h1>
    <form action="${pageContext.request.contextPath}/member/update.do" method="post">
 		ID : <input type="text" name="id" required value="${userDto.id}" /><br />
        NAME : <input type="text" name="name" required value="${userDto.name}" /><br />
        PW : <input type="password" name="pw" required value="${userDto.pw}" /><br />
        ADDR : <input type="text" name="addr" required value="${userDto.addr}" /><br />
        PHONE : <input type="text" name="phone" required value="${userDto.phone}" />
        <input type="submit" value="수정하기" />
    </form>
</body>
</html>
