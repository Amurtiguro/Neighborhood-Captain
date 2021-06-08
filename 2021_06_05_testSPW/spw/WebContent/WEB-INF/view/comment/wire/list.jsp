<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 목록</title>
</head>
<body>
<table border>
	<tr>
		<th>댓글번호</th>
		<th>내용</th>
		<th>그룹번호</th>
		<th>타겟번호</th>
		<th>상품번호</th>
		<th>작성날짜</th>
		<th>회원번호</th>
		<th>회원이름</th>
		<th>회원 ID</th>
		<th>대댓글</th>
		<th>타겟</th>
		<th>답글</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
<c:if test="${empty commentList}">
	<tr>
		<td colspan="14" align="center">댓글이 없습니다.</td>
	</tr>
</c:if>
<c:forEach items="${commentList}" var="cvo">
	<c:if test="${cvo.cdelyn == 'Y'}">
		<tr>
			<td colspan="9" align="center">삭제된 댓글입니다.</td>
			<td colspan="5">
				<c:if test="${empty cvo.ctargetnum}">최상위 댓글</c:if>
				<c:if test="${not empty cvo.ctargetnum}">대 댓글</c:if>
			</td>
		</tr>
	</c:if>
	<c:if test="${cvo.cdelyn == 'N'}">
		<tr>
			<td>${cvo.cnum}</td>
			<td>${cvo.ccontents}</td>
			<td>${cvo.cgroupnum}</td>
			<td>${cvo.ctargetnum}</td>
			<td>${cvo.cpnum}</td>
			<td>${cvo.cindate}</td>
			<td>${cvo.mnum}</td>
			<td>${cvo.mname}</td>
			<td>${cvo.mid}</td>
			<td>
				<c:if test="${empty cvo.ctargetnum}">최상위 댓글</c:if>
				<c:if test="${not empty cvo.ctargetnum}">대 댓글</c:if>
			</td>
			<td>${cvo.tarname}</td>
			<td>
				<a href="/spw/comment/insert.spw?cpnum=${param.cpnum}&cgroupnum=${cvo.cgroupnum}&ctargetnum=${cvo.cnum}">답글</a>
			</td>
			<td>
				<a href="/spw/comment/update.spw?cnum=${cvo.cnum}">수정</a>
			</td>
			<td>
				<a href="/spw/comment/delete.spw?cnum=${cvo.cnum}">삭제</a>
			</td>
		</tr>
	</c:if>
</c:forEach>
</table>

<jsp:include page="/comment/insert.spw">
	<jsp:param name="cpnum" value="${param.cpnum}"/>
</jsp:include>

</body>
</html>