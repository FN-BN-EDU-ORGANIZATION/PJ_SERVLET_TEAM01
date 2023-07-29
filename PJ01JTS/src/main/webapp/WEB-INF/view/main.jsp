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
<!-- 나의 메뉴이동 -->
<c:if test="${not empty role}">
	<a class="mypage_btn" href=<c:url value="/mypage.do" /> >마이페이지</a></br>
</c:if>

<!-- 사서 메뉴로 이동하기 -->
<!-- 회원 메뉴로 이동하기 -->


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


<!-- axios cdn -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.4.0/axios.min.js" integrity="sha512-uMtXmF28A2Ab/JJO2t/vYhlaa/3ahUOgj1Zf27M5rOo8/+fcTUVH0/E0ll68njmjrLqOBjXM3V9NiPFL5ywWPQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>">
<script>
	const mypage_btn_el=document.querySelector('.mypage_btn');
	mypage_btn_el.addEventListener('click',function(){
		const projectPath = '${pageContext.request.contextPath}';
		console.log("mypage_btn_el click",projectPath);
		
		const info_block_el = document.querySelector('.info_block');
		//axios
		axios.get("http://localhost:8080"+projectPath+"/mypage.do")
		.then(response=>{
			console.log("success!",response.data);
			const list = response.data;
			
			list.forEach((dto)=>{
				
				console.log('dto',dto);
				const dto_el = document.createElement('div');
				dto_el.classList.add("item");
				
				dto_el.innerHTML+="<span>"+dto.id+"</span><br/>";
				dto_el.innerHTML+="<span>"+dto.role+"</span><br/>";
				dto_el.innerHTML+="<span>"+dto.name+"</span><br/>";
				dto_el.innerHTML+="<span>"+dto.addr+"</span><br/>";
				dto_el.innerHTML+="<span>"+dto.phone+"</span><br/>";
				info_block_el.appendChild(dto_el);
			})
		})
		.catch(error=>{console.log("fail..");})
	})

</script>
 -->
</body>
</html>