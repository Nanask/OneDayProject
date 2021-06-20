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
	<table>
		<tr>
			<th>No.</th>
			<th>학번</th>
			<th>과목</th>
			<th>성적</th>
			
		</tr>
		<c:forEach items="${SC}" var="SC">
			<tr>
				<td>${SC.sc_Seq}</td>
				<td>${SC.sc_Stnum}</td>
				<td>${SC.sc_Subject}</td>
				<td>${SC.sc_Score}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>