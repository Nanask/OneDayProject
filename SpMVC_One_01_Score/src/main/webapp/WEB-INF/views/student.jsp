<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value ="${pageContext.request.contextPath }" var="rootPath" /> 
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
    
	button {
	text-align: right;
	padding: 10px;
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
<button id="btn_update" type="button" data-num="${ST.st_num}">학생정보 수정</button>

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
<button id="btn_delete" type="button">학생성적 삭제</button>
 
<script>
document.querySelector("button#btn_update").addEventListener("click",(e)=>{
	//let tagName = e.target.tagName;
	//alert("학생정보를 수정합니다.");
	let num = e.target.closest("button#btn_update").dataset.num;
	location.href="${rootPath}/student/stinsert?num=" +num;
});

document.querySelector("button#btn_delete").addEventListener("click",(e) => {
	let seq = e.target.closest("TR").dataset.seq;
	if(confirm(seq + "를 삭제합니다")) {
		location.replace("${rootPath}/student/delete?seq=" +seq)
	}
	alert(seq + "삭제합니다")

})
</script>

</html>

