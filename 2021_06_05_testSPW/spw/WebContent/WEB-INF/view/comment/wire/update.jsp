<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
<c:if test="${empty commentData}">
	<table border>
		<tr>
			<th>수정할 댓글이 없거나 삭제되었습니다.</th>
		</tr>
	</table>
</c:if>
<c:if test="${not empty commentData}">
<form action="/spw/comment/update.spw" method="POST">
	<c:forEach items="${commentData}" var="comment">
	<table border>
		<tr>
			<th>댓글번호</th>
			<td><input type="text" name="cnum" value="${comment.cnum}" readonly></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input type="text" name="ccontents" value="${comment.ccontents}"></td>
		</tr>
		<tr>
			<th>상품번호</th>
			<td><input type="text" name="cpnum" value="${comment.cpnum}" readonly></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="입력"></td>
		</tr>
	</table>
	</c:forEach>
</form>
</c:if>
</body>
</html>