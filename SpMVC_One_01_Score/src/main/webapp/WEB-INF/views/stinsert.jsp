<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>학생정보</legend>
		<table>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>학과</th>
				<th>학년</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
			<tr>
				<td>${ST.st_num}</td>
				<td>${ST.st_name}</td>
				<td>${ST.st_dept}</td>
				<td>${ST.st_grade}</td>
				<td>${ST.st_grade}</td>
				<td>${ST.st_tel}</td>
				<td>${ST.st_addr}</td>
			</tr>
		</table>
	</fieldset>

</body>
</html>