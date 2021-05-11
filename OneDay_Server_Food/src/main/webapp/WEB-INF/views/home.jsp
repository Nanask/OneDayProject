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
	
	<h1>다이어트 시작!!</h1>
	<h4>조회하고 싶은 날짜를 입력해주세요</h4>
	<form action ="food/list">
		<input name = "date">
		<button>조회하기</button>	
	</form>
   
   <h3>섭취 목록</h3>
   <table>
      <tr>
      	 <th></th><th>
         <th><th>날짜</th>
         <th>식품명</th>
         <th>섭취량</th>
         <th>총내용량</th>
         <th>에너지</th>
         <th>단백질</th>
         <th>지방</th>
         <th>탄수화물</th>
         <th>총당류</th>
      	</tr>
      <c:if test="${ empty MYFOOD }">결과가 없음!!</c:if>
      <c:forEach items="${MYFOOD}" var="MF">
         <tr>
         	<th>${MF.my_seq}</th><th>
            <th><th>${MF.my_date}</th>
            <th>${MF.fd_fname}</th>
            <th>${MF.my_eat}</th>
            <th>${MF.fd_all}</th>
            <th>${MF.fd_energy}</th>
            <th>${MF.fd_protein}</th>
            <th>${MF.fd_fat}</th>
            <th>${MF.fd_car}</th>
            <th>${MF.fd_sugars}</th>
         </tr>
      </c:forEach>
   </table>
	<h3><a href="food/insert">섭취정보 등록</a></h3>

</body>
</html>