<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value ="${pageContext.request.contextPath }" var="rootPath" />        
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
* {
	margin:0;
	padding: 0;
	border: 0;
	list-style: none;
}
	h1 {
		width: 100%;
		padding: 20px;
		text-align: center;
		background-color: #ccc;
	}
	
	nav.main_nav {
		background: #aaa;
		
	}
	
	nav.main_nav ul {
		display: flex;
	}
	
	nav.main_nav li {
		padding: 10px 30px;
		
	}
	
	nav.main_nav li:nth-of-type(4) {
		margin-left: auto; 
}
	table {
		text-align: center;
		border-collapse: collapse;
		width: 90%;
		margin: 20px auto;
	}
	table, tr  {
		border: 1px solid black;
	}
	
	table tr:hover {
		background-color: #ddd;
	}
</style>
<body>
	<h1>대한 고교 성적처리 2021</h1>
	<nav class="main_nav">
	<ul>
		<li>HOME</li>
		<li>학생정보</li>
		<li>성적알림표</li>
		<li>로그인</li>		
	</ul>
	</nav>
	<table class="list">
	<tr>
		<th>학번</th>
		<th>이름</th>
		<th>전공</th>
		<th>학년</th>
		<th>응시과목</th>
		<th>총점</th>
		<th>평균</th>	
	</tr>
	   
	<c:forEach items="${LIST}" var="list">
	<tr data-num="${list.num}">
		<td>${list.num}</td>
		<td>${list.name}</td>
		<td>${list.dept}</td>
		<td>${list.grade}</td>
		<td>${list.subject}</td>
		<td>${list.total}</td>
		<td>${list.avg}</td>
	</tr>
	</c:forEach>
	</table>
</body>
<script>
	document.querySelector("table.list").addEventListener("click" (e) => {
		
		let tagName = e.target.tagName;
		if(tagName == "TD") {
			let tr = e.target.closet("TR").dataset;
			alert(num + "조회합니다.");
			
		}
	});
</script>
</html>