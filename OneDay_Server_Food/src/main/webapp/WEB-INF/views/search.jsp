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
	<h1>식품목록</h1>
	  <table>
	      <tr>
	      	 <th>식품코드</th>
	         <th>식품명</th>
	         <th>분류코드</th>
	         <th>분류명</th>
	         <th>출시연도</th>
	         <th>제조사코드</th>
	         <th>제조사명</th>
	         <th>1회제공량</th>
	         <th>총내용량</th>
	         <th>에너지</th>
	         <th>단백질</th>
	         <th>지방</th>
	         <th>탄수화물</th>
	         <th>총당류</th>
	      </tr>
	  <c:if test="${ empty FOODLIST }">회원정보 없음</c:if>    
      <c:forEach items="${FOODLIST}" var="ML">
         <tr>
            <th><${ML.fd_pcode}</th>
            <th><a href="insert2?fd_pname=${ML.fd_pname}"></a></th>
            <th>${ML.fd_tcode}</th>
            <th>${ML.fd_group}</th>
            <th>${ML.fd_fdate}</th>
            <th>${ML.fd_ccode}</th>
            <th>${ML.fd_cname}</th>
            <th>${ML.fd_one}</th>
            <th>${ML.fd_all}</th>
            <th>${ML.fd_energy}</th>
            <th>${ML.fd_protein}</th>
            <th>${ML.fd_fat}</th>
            <th>${ML.fd_car}</th>
            <th>${ML.fd_sugars}</th> 
         </tr>
      </c:forEach>
   </table>
</body>
</html>