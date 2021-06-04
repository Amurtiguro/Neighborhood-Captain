<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 편집</title>
</head>
<body>
<form action="/spw/category/update.spw" method="POST">
	<table border="1">
		<tr>
			<th colspan="2">
				<h2>카테고리 편집</h2>
			</th>
		</tr>
	<c:if test="${empty list}">
		<tr>
			<td colspan="2" align="center">
				수정할 카테고리가 없습니다.
			</td>
		</tr>
	</c:if>
	<c:forEach items="${list}" var="category">
		<tr>
			<th>카테고리 이름</th>
			<td>
				<input type="text" name="cgname" value="${category.cgname}">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="hidden" name="cgnum" value="${category.cgnum}">
				<input type="submit" value="편집">
			</td>
		</tr>
	</c:forEach>
	</table>
</form>
</body>
</html>