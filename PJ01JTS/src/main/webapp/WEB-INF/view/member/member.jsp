<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER PAGE</title>
<style>
		<%@include file="/resources/static/css/common.css" %>
		<%@include file="/resources/static/css/header.css" %>
		<%@include file="/resources/static/css/member_Page.css" %>
		<%@include file="/resources/static/css/footer.css" %>		
</style>
</head>
<body>
<div class="wrapper">
<header>
   <div class="log-header">
       <a href=<c:url value="/indexlog.do" />><img class="logo" src="resources/static/img/로고.png" alt=""></a>
       <ul>
          <li><a href=""><img  src="resources/static/img/english.png" alt="">ENGLISH</a></li>
       </ul>
    </div>
    <div class="logheader_line"></div>
</header>
<section class="member">

<div>
	<hr/>
	<a href="javascript:history.go(-1)">이전으로</a>
	
	<form action="member/delete.do" method="post">
    	<input type="text" name="id" placeholder="사용자 검색">
    	<button type="submit"  onclick="submitForm()">삭제</button>
	</form>
</div>




<form action="member/search.do" method="post">
   <div class="search_block">
    <input type="text" name="id" placeholder="검색할 id를 입력하세요">
    <button class="oneuser" type="submit" >검색</button>
    </div>
    <div class="oneshowBlock"></div>
    <hr />
</form> 


<div class="oneshowBlock">
    <!-- 검색 결과를 보여줄 영역 -->
</div>
<hr />


<hr />
<button class="alluser" >모든회원검색</button>
<div class="showBlock"></div>
<hr />

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




<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.4.0/axios.min.js" integrity="sha512-uMtXmF28A2Ab/JJO2t/vYhlaa/3ahUOgj1Zf27M5rOo8/+fcTUVH0/E0ll68njmjrLqOBjXM3V9NiPFL5ywWPQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
/*  const onesearch_btn_el = document.querySelector('.oneuser');
onesearch_btn_el.addEventListener('click', function(){
	console.log('oneuser clicked..');
	const projectPath = '${pageContext.request.contextPath}';
	  //axios
	  axios.get("http://localhost:9090" + projectPath + "/member/search.do")
	    .then(response => {
	      console.log('response', response);

	      const oneshowBlock_el = document.querySelector('.oneshowBlock'); 
	      
	      // 기존 내용을 모두 지우기
	      oneshowBlock_el.innerHTML = '';
	      
	        const list = response.data;
	      list.forEach((dto) => {

	        console.log('dto', dto);
	     
	        const dto_el = document.createElement('div');
	        dto_el.classList.add("item");

	        dto_el.innerHTML += "<span>" + dto.id + "</span> ";
	        dto_el.innerHTML += "<span>" + dto.role + "</span> ";
	        dto_el.innerHTML += "<span>" + dto.name + "</span> ";
	        dto_el.innerHTML += "<span>" + dto.addr + "</span>";
	        dto_el.innerHTML += "<span>" + dto.phone + "</span><br/>";
	        oneshowBlock_el.appendChild(dto_el);
	        
	      });
	    })
	    .catch(error => {
	      console.log("조회 실패..");
	    });
}); 
 */






const allsearch_btn_el = document.querySelector('.alluser');
allsearch_btn_el.addEventListener('click', function () {
  console.log('alluser clicked..');
  const projectPath = '${pageContext.request.contextPath}';
  //axios
  axios.get("http://localhost:9090" + projectPath + "/member/allsearch.do")
    .then(response => {
      console.log('response', response);

      const showBlock_el = document.querySelector('.showBlock');
      
        // 기존 내용을 모두 지우기
      showBlock_el.innerHTML = '';
      
        const list = response.data;
      list.forEach((dto) => {

        console.log('dto', dto);
     
        const dto_el = document.createElement('div');
        dto_el.classList.add("item");

        dto_el.innerHTML += "<span>" + dto.id + "</span> ";
        dto_el.innerHTML += "<span>" + dto.role + "</span> ";
        dto_el.innerHTML += "<span>" + dto.name + "</span> ";
        dto_el.innerHTML += "<span>" + dto.addr + "</span>";
        dto_el.innerHTML += "<span>" + dto.phone + "</span><br/>";
        showBlock_el.appendChild(dto_el);
        
      });
    })
    .catch(error => {
      console.log("조회 실패..");
    });
});



</script>
	

</body>
</html>