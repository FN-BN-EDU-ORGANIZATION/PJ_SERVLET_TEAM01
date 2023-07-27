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

	Account : ${ID} <br /> 
	Role : ${ROLE} <br />
	<hr />


	<div>
		<div class="search_block">
			<input type="text" id="searchInput" placeholder="keyword"
				style="width: 1500px; margin-bottom: 10px;"  />
			<button class="search_btn">검색</button>
		</div>
		<div class="show_block"
			style="width: 1600px; height: 700px; border: 1px solid; overflow: auto;">
			<table>
				<tr>
					<th>Name</th>
					<th>Artist</th>
					<th>URL</th>
				</tr>
			</table>
		</div>
	</div>
	
	
<hr/>
<c:if test="${empty ROLE}">
	<a href=<c:url value="/login.do" /> >LOGIN</a></br>
</c:if>
<c:if test="${not empty ROLE}">
	<a href=<c:url value="/logout.do" /> >LOGOUT</a></br>
</c:if>



	<!-- axios cdn -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.4.0/axios.min.js"
		integrity="sha512-uMtXmF28A2Ab/JJO2t/vYhlaa/3ahUOgj1Zf27M5rOo8/+fcTUVH0/E0ll68njmjrLqOBjXM3V9NiPFL5ywWPQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script>
	const search_btn_el = document.querySelector('.search_btn');
	const search_input_el = document.getElementById('searchInput');
	search_btn_el.addEventListener('click',function(){
		const projectPath = '${pageContext.request.contextPath}';	
		const ServerPort = '${pageContext.request.serverPort}';
		
		//const show_block_el = document.querySelector('.show_block');
		const table_el = document.querySelector('.show_block table');
		
		// 이전 검색 결과를 지움
    	//show_block_el.innerHTML = '';
		table_el.innerHTML = '<tr><th>Name</th><th>Artist</th><th>URL</th></tr>';
    
		
		 // input 요소에서 검색어를 가져옴
    	const searchText = document.querySelector('input[type="text"]').value;
    
		
		axios.get("http://localhost:" + ServerPort + projectPath + "/music/search.do",{
			params: { searchText: searchText } // 검색어를 파라미터로 전달
		})
		.then(response=>{ 
			const list = response.data;
			
			list.forEach((dto)=>{
				
				/* const dto_el = document.createElement('div');
				dto_el.classList.add("item");
				
				dto_el.innerHTML+="<span>"+dto.name+"</span> ";
				dto_el.innerHTML+="<span>"+dto.artist+"</span> ";
				dto_el.innerHTML+="<span>"+dto.url+"</span> <br/>";
				show_block_el.appendChild(dto_el); */
				
				const row = document.createElement('tr');
	            
	            const nameCell = document.createElement('td');
	            nameCell.innerText = dto.name;
	            
	            const artistCell = document.createElement('td');
	            artistCell.innerText = dto.artist;
	            
	            const urlCell = document.createElement('td');
	            const urlLink = document.createElement('a');
	            urlLink.href = dto.url;
	            urlLink.innerText = dto.url;
	            urlLink.target = '_blank';
	            urlCell.appendChild(urlLink);
	            
	            row.appendChild(nameCell);
	            row.appendChild(artistCell);
	            row.appendChild(urlCell);
	            
	            table_el.appendChild(row);
			})
			
			})		//성공시 처리로직
		.catch(error=>{alert("fail..!");})		//실패시 처리로직
		
	})
	
	search_input_el.addEventListener('keydown', function (event) {
		const projectPath = '${pageContext.request.contextPath}';
		const ServerPort = '${pageContext.request.serverPort}';
		console.log("확인 : " ,typeof event.keyCode);
		if (event.keyCode === 13) {
			
			//const show_block_el = document.querySelector('.show_block');
			const table_el = document.querySelector('.show_block table');
			
			// 이전 검색 결과를 지움
	    	//show_block_el.innerHTML = '';
			table_el.innerHTML = '<tr><th>Name</th><th>Artist</th><th>URL</th></tr>';
	    
			
			 // input 요소에서 검색어를 가져옴
	    	const searchText = document.querySelector('input[type="text"]').value;
	    
			
			axios.get("http://localhost:" + ServerPort + projectPath + "/music/search.do",{
				params: { searchText: searchText } // 검색어를 파라미터로 전달
			})
			.then(response=>{ 
				const list = response.data;
				
				list.forEach((dto)=>{
					
					const row = document.createElement('tr');
		            
		            const nameCell = document.createElement('td');
		            nameCell.innerText = dto.name;
		            
		            const artistCell = document.createElement('td');
		            artistCell.innerText = dto.artist;
		            
		            const urlCell = document.createElement('td');
		            const urlLink = document.createElement('a');
		            urlLink.href = dto.url;
		            urlLink.innerText = dto.url;
		            urlLink.target = '_blank';
		            urlCell.appendChild(urlLink);
		            
		            row.appendChild(nameCell);
		            row.appendChild(artistCell);
		            row.appendChild(urlCell);
		            
		            table_el.appendChild(row);
				})
				
				})		
			.catch(error=>{alert("fail..!");})
		}
	});
	
</script>

</body>
</html>