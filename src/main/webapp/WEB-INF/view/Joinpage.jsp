<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		<%@include file="/resources/static/css/common.css" %>
		<%@include file="/resources/static/css/header.css" %>
		<%@include file="/resources/static/css/Join_Page.css" %>
		<%@include file="/resources/static/css/footer.css" %>		
	</style>

</head>
<body>
	
	 <div class="wrapper">
        <!-- header -->
            <!-- top-header -->
            <header>
                <div class="log-header">
                    <a href=<c:url value="/index.do" />><img class="logo" src="resources/static/img/로고.png" alt=""></a>
                    <ul>
                        <li><a href=""><img  src="resources/static/img/english.png" alt="">ENGLISH</a></li>
                    </ul>
                </div>
                <div class="logheader_line"></div>
            </header>
            
            <section class="join">
                <h1>워터멜론과 함께 하세요!</h1>
                <form action="${pageContext.request.contextPath}/member/add.do" method="post" id="joinForm">
                <ul>
                    <li><span>ID</span>
                        <!-- <span id="id_check">*id중복여부표시</span> -->
                        <input id="id_input" name="id" type="text" placeholder="아이디" title="아이디입력" required><button id="idcheck_btn">중복확인</button></li>    
                    <li><span>PW</span>
                        <input id="pw_input" name="pw" type="password" placeholder="비밀번호" title="비밀번호입력" required></li>
                    <li><span>PW Check</span>
                        <!-- <span id="pw_check">*pw체크표시</span> -->
                        <input id="pwc_input" name="pwc" type="password" placeholder="비밀번호확인" title="비밀번호확인" required></li>
                    <li><span>NAME</span>
                        <input type="text"  name="name" placeholder="이름" title="이름입력" required></li>
                    <li><span>ADDRESS</span>
                        <input id="addr_input"  name="addr"  type="text" placeholder="주소" title="주소입력" required><button id="addr_btn">주소검색</button></li>
                    <li><input id="phone_input" type="text" placeholder="동/호수 입력" title="주소입력"></li>
                    <li><span>PHONE</span>
                        <input type="text" name="phone" placeholder="핸드폰번호" title="핸드폰번호입력" required></li>
                    <li><button id="join_btn" onclick="button_function()">JOIN!</button></li>
                </ul>
                </form>
            </section>

			<!-- <script>
			
			function button_function() {
			    var id = document.getElementById("id_input").value;
			    fetch("${pageContext.request.contextPath}/member/add.do", {
			        method: "POST",
			        headers: {
			            "Content-Type": "application/x-www-form-urlencoded"
			        },
			        body: "id=" + encodeURIComponent(id)
			    })
			    .then(response => response.text())
			    .then(data => {
			        if (data.trim() === "true") { 
			            alert("회원가입에 성공하였습니다!");
			            window.location.href = "${pageContext.request.contextPath}/index.do";
			        } else if (data.trim() === "false") { 
			            alert("회원가입에 실패하였습니다.");
			        } else {
			            alert("서버 오류가 발생하였습니다.");
			        }
			    })
			}

					
				
			</script> -->


            <footer>
                <div class="footer_line"></div>
                <div>
                    <ul class="footer_menu">
                        <li><a href="">이용약관</a></li>
                        <li><a href="">고객센터</a></li>
                        <li><a href="">제휴/프로모션</a></li>
                        <li><a href=""> 개인정보처리방침</a></li>
                    </ul>
                </div>
                <p></p>
                <div class="Site_info">
                    <img id="footer_logo" src="resources/static/img/로고.png" alt="">
                    <span class="Sitename">(주)WATERMELON MUSIC</span>
                    <span>대구광역시 중구 중앙대로 366 반월센트럴타워 10층</span>
                    <span>대표이사 : 윤치연, 김예솔, 이헌지, 최정기</span>
                    <span>사업자등록번호 : 024-04-02023</span>
                    <br>
                    <span>문의전화 : 1544-1111 (평일 09:00-18:00)</span>
                    <span>WATERMELON MUSIC으로 음악과 함께하는 즐거운 하루 보내세요!</span>
                </div>
                
            </footer>
    </div>
</body>
</html>