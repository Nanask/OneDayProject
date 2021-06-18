<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	table, tr, th {
		border: 1px solid black;

	
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
	<table>
	<tr>
		<th>학번</th>
		<th>이름</th>
		<th>전공</th>
		<th>학년</th>
		<th>응시과목</th>
		<th>총점</th>
		<th>평균</th>	
	</tr>
	<c:forEach items"${}
	<tr>
	
	</tr>
	</table>
</body>
</html>