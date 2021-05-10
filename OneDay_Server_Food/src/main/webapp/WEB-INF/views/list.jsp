<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>해당 날짜의 목록을 출력합니다.</h1>
	<h5>날짜 : ${MYFOOD.my_date})</h5>
	<h5>식품명 : ${MYFOOD.fd_fname}</h5>
	<h5>섭취량 : ${MYFOOD.my_eat}</h5>
	<h5>총내용량(g) : ${MYFOOD.fd_all}</h5>
	<h5>에너지(k) : ${MYFOOD.fd_energy}</h5>
	<h5>단백질(g) : ${MYFOOD.fd_protein}</h5>
	<h5>지방(g) : ${MYFOOD.fd_fat}</h5>
	<h5>탄수화물(g) : ${MYFOOD.fd_car}</h5>
	<h5>총당류(g) : ${MYFOOD.fd_sugers}</h5>
</body>
</html>