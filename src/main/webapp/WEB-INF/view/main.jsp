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
			<input type="text" placeholder="keyword"
				style="width: 1500px; margin-bottom: 10px;" />
			<button class="search_btn">�˻�</button>
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

	<!-- axios cdn -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.4.0/axios.min.js"
		integrity="sha512-uMtXmF28A2Ab/JJO2t/vYhlaa/3ahUOgj1Zf27M5rOo8/+fcTUVH0/E0ll68njmjrLqOBjXM3V9NiPFL5ywWPQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script>
	const search_btn_el = document.querySelector('.search_btn');
	search_btn_el.addEventListener('click',function(){
		const projectPath = '${pageContext.request.contextPath}';	
		const ServerPort = '${pageContext.request.serverPort}';
		
		//const show_block_el = document.querySelector('.show_block');
		const table_el = document.querySelector('.show_block table');
		
		// ���� �˻� ����� ����
    	//show_block_el.innerHTML = '';
		table_el.innerHTML = '<tr><th>Name</th><th>Artist</th><th>URL</th></tr>';
    
		
		 // input ��ҿ��� �˻�� ������
    	const searchText = document.querySelector('input[type="text"]').value;
    
		
		axios.get("http://localhost:" + ServerPort + projectPath + "/music/search.do",{
			params: { searchText: searchText } // �˻�� �Ķ���ͷ� ����
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
			
			})		//������ ó������
		.catch(error=>{alert("fail..!");})		//���н� ó������
		
	})
</script>

</body>
</html>