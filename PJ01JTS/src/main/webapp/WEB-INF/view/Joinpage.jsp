<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                    <a href="./index.jsp"><img class="logo" src="resources/static/img/로고.png" alt=""></a>
                    <ul>
                        <li><a href=""><img  src="resources/static/img/english.png" alt="">ENGLISH</a></li>
                    </ul>
                </div>
                <div class="logheader_line"></div>
            </header>
            
            <section class="join">
                <h1>워터멜론과 함께 하세요!</h1>
                <ul>
                    <li><span>ID</span>
                        <!-- <span id="id_check">*id중복여부표시</span> -->
                        <input id="id_input" type="text" placeholder="아이디" title="아이디입력"><button id="idcheck_btn">중복확인</button></li>    
                    <li><span>PW</span>
                        <input id="pw_input" type="password" placeholder="비밀번호" title="비밀번호입력"></li>
                    <li><span>PW Check</span>
                        <!-- <span id="pw_check">*pw체크표시</span> -->
                        <input id="pwc_input" type="password" placeholder="비밀번호확인" title="비밀번호확인"></li>
                    <li><span>NAME</span>
                        <input type="text" placeholder="이름" title="이름입력"></li>
                    <li><span>ADDRESS</span>
                        <input id="addr_input" type="text" placeholder="주소" title="주소입력"><button id="addr_btn">주소검색</button></li>
                    <li><input type="text" placeholder="동/호수 입력" title="주소입력"></li>
                    <li><span>PHONE</span>
                        <input type="text" placeholder="핸드폰번호" title="핸드폰번호입력"></li>
                    <li><button id="join_btn" onclick="alert('WATERMELON의 멤버가 되신 것을 환영합니다 =D')">JOIN!</button></li>
                </ul>
            </section>

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