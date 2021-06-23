<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
</body>
<style>
table.score tr {
	border-bottom: 1px solid black;
}

div.button {
	border: none;
	width: 10%;
	height: 40px;
	margin: 10px auto;
	font-weight: bold;
	right: 20%;
}

div.button:hover {
	background-color: #dedcee;
}
</style>

<table>
	<tr data-num="${ST.st_num}">
		<th>학번</th>
		<td>${ST.st_num}</td>
		<th>전공</th>
		<td>${ST.st_dept}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${ST.st_name}</td>
		<th>학년</th>
		<td>${ST.st_grade}</td>
	</tr>
</table>
<div>
	<button id="btn_update" type="button" data-num="${ST.st_num}">학생정보
		수정</button>
</div>

<table class="score">
	<tr>
		<th>NO.</th>
		<th>과목명</th>
		<th>점수</th>
	</tr>
	<c:forEach items="${SC}" var="SC">
		<tr data-seq="${SC.sc_Seq}">
			<td>${SC.sc_Seq}</td>
			<td>${SC.sc_Subject}</td>
			<td>${SC.sc_Score}</td>
		</tr>
	</c:forEach>
</table>
<div class="button">
	<button id="btn_delete" type="button">학생성적 삭제</button>
</div>
<script>
document.querySelector("button#btn_update").addEventListener("click",(e)=>{
	//let tagName = e.target.tagName;
	let num = e.target.closest("button#btn_update").dataset.num;
	alert(num + "학생정보를 수정합니다.");
	location.href="${rootPath}/student/stinsert?num=" +num;
});

document.querySelector("button#btn_delete").addEventListener("click",(e) => {
	let seq = e.target.closest("TR").dataset.seq;
	if(confirm(seq + "를 삭제합니다")) {
		location.replace("${rootPath}/student/delete?seq=" +seq)
	}

})
</script>

</html>

