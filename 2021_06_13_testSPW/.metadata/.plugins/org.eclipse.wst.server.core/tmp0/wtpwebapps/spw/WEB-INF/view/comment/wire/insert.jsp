<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty commentParam}">
	<table border>
		<tr>
			<th>오류! 파라미터 없음</th>
		</tr>
	</table>
</c:if>
<c:if test="${not empty commentParam}">
<form action="/spw/comment/insert.spw" method="POST">
	<table border>
		<c:if test="${not empty commentParam.cgroupnum}">
		<tr>
			<th>그룹번호</th>
			<td><input type="text" name="cgroupnum" value="${commentParam.cgroupnum}" readonly></td>
		</tr>
		</c:if>
		<c:if test="${not empty commentParam.ctargetnum}">
		<tr>
			<th>타겟번호</th>
			<td><input type="text" name="ctargetnum" value="${commentParam.ctargetnum}" readonly></td>
		</tr>
		</c:if>
		<tr>
			<th>내용</th>
			<td><input type="text" name="ccontents"></td>
		</tr>
		<tr>
			<th>상품번호</th>
			<td><input type="text" name="cpnum" value="${param.cpnum}" readonly></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="입력"></td>
		</tr>
	</table>
</form>
</c:if>