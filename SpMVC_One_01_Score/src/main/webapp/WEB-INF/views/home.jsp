<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value ="${pageContext.request.contextPath }" var="rootPath" />        
    
<!DOCTYPE html>
<html>
<%@ include file ="/WEB-INF/views/include/include_head.jspf" %>
<style>

	
	table.list {
		text-align: center;
		border-collapse: collapse;
		width: 90%;
		margin: 40px auto;
	}
	table.list tr  {
		border: 1px solid black;
	}
	table.list th {
		background-color:#fffad3;
	}
	
	table.list tr:hover {
		background-color: #ffe1ae;
	}
</style>

<body>
	<%@ include file ="/WEB-INF/views/include/include_header.jspf" %>
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
	document.querySelector("table.list").addEventListener("click",(e) => {
		
		let tagName = e.target.tagName;
		console.log(tagName);
		if(tagName == "TD") {
			let num = e.target.closest("TR").dataset.num;
			console.log(num);
			alert(num + "조회합니다.");
			location.href="${rootPath}/student/stlist?num=" +num;	
			
		}
	});
</script>
</html>