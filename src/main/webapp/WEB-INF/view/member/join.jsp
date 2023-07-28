<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입 폼</h1>
    <form action="process_signup" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required><br>

        <label for="pw">비밀번호:</label>
        <input type="password" id="pw" name="pw" required><br>

        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="addr">주소:</label>
        <input type="text" id="addr" name="addr" required><br>

        <label for="phone">전화번호:</label>
        <input type="text" id="phone" name="phone" required><br>

        <label for="role">역할:</label>
        <select id="role" name="role" required>
            <option value="admin">관리자</option>
            <option value="user">사용자</option>
        </select><br>

        <input type="submit" value="가입하기">
    </form>




</body>
</html>