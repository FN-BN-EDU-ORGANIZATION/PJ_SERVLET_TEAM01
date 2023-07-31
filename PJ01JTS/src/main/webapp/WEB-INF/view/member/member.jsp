<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>MEMBER PAGE</h1>
ID : ${ID}
<hr>

<div>
	<hr/>
	<a href="javascript:history.go(-1)">이전으로</a>
	
	<form action="member/delete.do" method="post">
    	<input type="text" name="id" placeholder="사용자 검색">
    	<button type="submit"  onclick="submitForm()">삭제</button>
	</form>
</div>

<form action="member/search.do" method="post">
    <input type="text" name="id" placeholder="검색어를 입력하세요">
    <button type="submit"  onclick="submitSearch()">검색</button>
    <hr />
    ${msg }
</form>

<!-- <hr />
회원조회하기
<div class="search_block">
	<input placeholder="userid" />
	<button class="search_btn">조회하기</button>
</div>
<div class="show_block">
	
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.4.0/axios.min.js" integrity="sha512-uMtXmF28A2Ab/JJO2t/vYhlaa/3ahUOgj1Zf27M5rOo8/+fcTUVH0/E0ll68njmjrLqOBjXM3V9NiPFL5ywWPQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
const search_btn_el=document.querySelector('.search_btn');
	mypage_btn_el.addEventListener('click',function(){
	const projectPath = '${pageContext.request.contextPath}';
	console.log("search_btn_el click",projectPath);
	
	const show_block_el = document.querySelector('.show_block');
	//axios
	axios.get("http://localhost:8080"+projectPath+"/member/search.do")
	.then(response=>{
		console.log("success!",response.data);
		const list = response.data;
		
		list.forEach((dto)=>{
			
			console.log('dto',dto);
			const dto_el = document.createElement('div');
			dto_el.classList.add("item");
			
			dto_el.innerHTML+="<span>"+dto.id+"</span>";
			dto_el.innerHTML+="<span>"+dto.role+"</span>";
			dto_el.innerHTML+="<span>"+dto.name+"</span>";
			dto_el.innerHTML+="<span>"+dto.addr+"</span>";
			dto_el.innerHTML+="<span>"+dto.phone+"</span><br/>";
			info_block_el.appendChild(dto_el);
		})
	})
	.catch(error=>{console.log("fail..");})
}) -->
	

</body>
</html>