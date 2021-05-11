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
		<h1>식품명을 검색해주세요</h1>
		<table>
			<tr>
				<th>식품명</th><td><input name="name"></td>
				<th></th><td><a href="/food/insert/search"><button>식품코드 찾기</button></a></td>
			</tr>	
		</table>

</body>
</html>