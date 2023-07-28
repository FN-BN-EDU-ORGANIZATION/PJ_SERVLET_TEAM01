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


<!-- 도서 대여 기능 -->
<h2>도서 대여 등록하기(비동기 요청)</h2>
MSG : <span class="add_msg"></span>
<hr>
<div>
	<form action="a.jsp" onSubmit="return false" name="lendAddForm">
		<input type="text" name="bookcode" placeholder="bookcode"				/>
		<input type="text" name="id" 	placeholder="id"				/>
		<button class="lend_add_btn">등록요청</button>
	</form>

</div>
<!-- axios cdn -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.4.0/axios.min.js" integrity="sha512-uMtXmF28A2Ab/JJO2t/vYhlaa/3ahUOgj1Zf27M5rOo8/+fcTUVH0/E0ll68njmjrLqOBjXM3V9NiPFL5ywWPQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
	const lend_add_btn_el = document.querySelector('.lend_add_btn');
	
	
	lend_add_btn_el.addEventListener('click',function(){
		
		const projectPath='${pageContext.request.contextPath}';
		const ServerPort = '${pageContext.request.serverPort}';
		
		const form=document.lendAddForm;
		const params = {params :{'bookcode':form[0].value,'id':form[1].value } }
		
		axios.post("http://192.168.2.254:"+ ServerPort + projectPath +"/lend/add.do",null,params)
		.then(response=>{
			console.log('response',response);
			console.log('response',response.data);

			document.querySelector(".add_msg").innerHTML=response.data;
		})
		.catch(error=>{})
		
	})

	
</script>

<!-- 도서 대여 내역 조회 -->

<!--  -->
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
</form>



<script>
function submitSearch(event){	

	
}

function submitForm(event) {
	alert("삭제되었다")
}
</script>











</body>
</html>