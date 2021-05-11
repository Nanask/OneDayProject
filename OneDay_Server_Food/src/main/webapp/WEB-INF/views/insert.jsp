<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="food/search">
		<h1>섭취리스트 추가</h1>
		<table>
			<tr>
				<th>날짜</th><td><input name="date"></td>
				<th>식품명</th><td><input name="name"></td>
				<th></th><td><a href="/food/search"></a><button>식품코드 찾기</button></td>
				<th>섭취량</th><td><input name="eat"></td>
			</tr>
			
		</table>
	</form>

</body>
</html>