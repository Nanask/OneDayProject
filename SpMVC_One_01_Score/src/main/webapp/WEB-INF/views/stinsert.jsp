<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>

<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<form method="POST">
		<fieldset>
			<legend>학생정보</legend>
			<div>
				<label>학번</label> <input type="text" name="st_num"
					value="${ST.st_num}">
			</div>
			<div>
				<label>이름</label> <input type="text" name="st_name"
					value="${ST.st_name}">
			</div>
			<div>
				<label>학과</label> <input type="text" name="st_dept"
					value="${ST.st_dept}">
			</div>
			<div>
				<label>학년</label> <input type="text" name="st_grade"
					value="${ST.st_grade}">
			</div>
			<div>
				<label>전화번호</label> <input type="text" name="st_tel"
					value="${ST.st_tel}">
			</div>
			<div>
				<label>주소</label> <input type="text" name="st_addr"
					value="${ST.st_addr}">
			</div>
			<div class="button">
				<button>정보 수정</button>
				<button>정보 삭제</button>
			</div>
		</fieldset>
	</form>
</body>
</html>