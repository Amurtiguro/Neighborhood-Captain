<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th colspan="3">
				<h2>카테고리 목록</h2>
			</th>
		</tr>
		<tr>
			<th>코드</th>
			<th>이름</th>
			<th>편집</th>
		</tr>
	<c:if test="${empty list}">
		<tr>
			<td colspan="3" align="center">
				카테고리가 없습니다.
			</td>
		</tr>
	</c:if>
	<c:forEach items="${list}" var="cvo">
		<tr>
			<td>${cvo.cgnum}</td>
			<td>${cvo.cgname}</td>
			<td>
				<a href="/spw/category/update.spw?cgnum=${cvo.cgnum}">[ 편집 ]</a>
			</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="3" align="right">
				<a href="/spw/category/insert.spw">[ 추가 ]</a>
			</td>
		</tr>
	</table>
</body>
</html>